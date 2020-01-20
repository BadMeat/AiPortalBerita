package com.dolan.aiportalberita.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolan.aiportalberita.*
import com.dolan.aiportalberita.viewmodel.FavoriteViewModel
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite.*
import javax.inject.Inject


class FavoriteFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var favoriteAdapter: BusinessAdapter

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent.newFavoriteComponent()
            .inject(this)
        favoriteViewModel =
            ViewModelProviders.of(this, viewModelFactory)[FavoriteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).showNavigation()

        favoriteAdapter = BusinessAdapter {

        }

        favoriteViewModel.getFavoriteRemote()
        initObserver()

        rv_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoriteAdapter
        }
    }

    private fun initObserver() {
        favoriteViewModel.getfavoriteList().observe(this, Observer {
            favoriteAdapter.setListBusiness(it)
            rv_main.visible()
        })
        favoriteViewModel.isLoading().observe(this, Observer {
            progress_bar.visibility = if (it) View.VISIBLE else View.GONE
            if (it) {
                rv_main.invisible()
            } else {
                rv_main.visible()
            }
        })
    }
}
