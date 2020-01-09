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
import com.dolan.aiportalberita.viewmodel.TechnologyViewModel
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_technology.*
import javax.inject.Inject

class TechnologyFragment : Fragment(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: TechnologyViewModel
    private val adapterTechnology = BusinessAdapter()

    private lateinit var searchView: SearchView

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.applicationContext as BaseApp)
            .appComponent.newTechnologyComponent()
            .inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[TechnologyViewModel::class.java]
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val myMenu = menu.findItem(R.id.menu_search)
        searchView = myMenu.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_technology, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getRemoteList()
        observerNews()
        rv_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterTechnology
        }

    }

    private fun observerNews() {
        viewModel.getListTechnology().observe(this, Observer {
            adapterTechnology.setListBusiness(it)
        })
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        adapterTechnology.filter.filter(p0)
        return true
    }


}
