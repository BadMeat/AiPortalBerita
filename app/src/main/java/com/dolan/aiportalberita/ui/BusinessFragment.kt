package com.dolan.aiportalberita.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
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

class BusinessFragment : Fragment(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val businessAdapter = BusinessAdapter()

    private lateinit var businessListViewModel: BusinessListViewModel

    private lateinit var searchView: SearchView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent
            .newBussinesListComponent().inject(this)

        businessListViewModel =
            ViewModelProviders.of(this, viewModelFactory)[BusinessListViewModel::class.java]
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val myMenu = menu.findItem(R.id.menu_search)
        searchView = myMenu?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_byussines, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        businessListViewModel.getBusinessList()
        observeNews()
        rv_main.apply {
            adapter = businessAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun observeNews() {
        businessListViewModel.getBusinessLiveList().observe(this, Observer {
            it?.let {
                businessAdapter.setListBusiness(it)
            }

        })
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        businessAdapter.filter.filter(p0)
        return true
    }
}
