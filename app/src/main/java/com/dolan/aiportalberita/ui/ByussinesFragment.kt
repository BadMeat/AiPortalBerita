package com.dolan.aiportalberita.ui


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolan.aiportalberita.BaseApp
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.viewmodel.BusinessListViewModel
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_byussines.*
import javax.inject.Inject

class ByussinesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val businessAdapter = BusinessAdapter()

    private lateinit var bussinesListViewModel: BusinessListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent
            .newBussinesListComponent().inject(this)

        bussinesListViewModel =
            ViewModelProviders.of(this, viewModelFactory)[BusinessListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_byussines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bussinesListViewModel.getBusinesList()
        observeNews()
        rv_main.apply {
            adapter = businessAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeNews() {
        bussinesListViewModel.getBusinessLiveList().observe(this, Observer {
            it?.let {
                businessAdapter.setListBusiness(it)
            }

        })
    }
}
