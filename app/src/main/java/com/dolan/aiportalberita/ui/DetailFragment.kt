package com.dolan.aiportalberita.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dolan.aiportalberita.BaseApp
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.databinding.FragmentDetailBinding
import com.dolan.aiportalberita.viewmodel.DetailViewModel
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewModel: DetailViewModel

    private lateinit var dataBinding: FragmentDetailBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent.detailComponent().inject(this)
        viewModel = ViewModelProviders.of(this, factory)[DetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerData()

        arguments?.let {
            val article = DetailFragmentArgs.fromBundle(it).article
            viewModel.getData(article)
        }
    }

    private fun observerData() {
        viewModel.getArticle().observe(this, Observer {
            dataBinding.article = it
        })
    }

}
