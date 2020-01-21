package com.dolan.aiportalberita.ui


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolan.aiportalberita.BaseApp
import com.dolan.aiportalberita.R
import com.dolan.aiportalberita.invisible
import com.dolan.aiportalberita.viewmodel.BerandaViewModel
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import com.dolan.aiportalberita.visible
import com.leinardi.android.speeddial.SpeedDialActionItem
import com.leinardi.android.speeddial.SpeedDialView
import kotlinx.android.synthetic.main.beranda_containt.*
import kotlinx.android.synthetic.main.fragment_beranda.*
import java.util.*
import javax.inject.Inject


class BerandaFragment : Fragment(), SpeedDialView.OnActionSelectedListener {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var berandaViewModel: BerandaViewModel
    private lateinit var berandaViewPager: BerandaViewPagger
    private lateinit var berandaAdapter: BusinessAdapter

    private val handler = Handler()
    private lateinit var runnable: Runnable
    private var timer: Timer? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent.newBerandaComponent()
            .inject(this)
        berandaViewModel = ViewModelProviders.of(this, factory)[BerandaViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contextThemeWrapper = ContextThemeWrapper(activity, R.style.AppTheme_NoAction)
        val localInflater = inflater.cloneInContext(contextThemeWrapper)
        return localInflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        speed_dial.addActionItem(
            SpeedDialActionItem.Builder
                (R.id.byussinesFragment, R.drawable.ic_business).create()
        )

        speed_dial.addActionItem(
            SpeedDialActionItem.Builder
                (R.id.technologyFragment, R.drawable.ic_computer).create()
        )

        speed_dial.setOnActionSelectedListener(this)

        berandaViewModel.refresh()
        initObserver()
        context?.let {
            berandaViewPager = BerandaViewPagger(it)
        }
        view_pagger.adapter = berandaViewPager

        initMovingPager()

        berandaAdapter = BusinessAdapter {
            val action = BerandaFragmentDirections.actionToDetail(it)
            Navigation.findNavController(view).navigate(action)
        }

        rv_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = berandaAdapter
        }
    }

    private fun initMovingPager() {
        timer = null
        timer = Timer()

        runnable = Runnable {
            view_pagger?.let {
                var i = it.currentItem
                if (i == berandaViewPager.articleItem.size - 1) {
                    i = 0
                } else {
                    i++
                }
                it.setCurrentItem(i, true)
            }
        }

        initTimer()
    }

    private fun initTimer() {
        timer?.schedule(object : TimerTask() {
            override fun run() {
                handler.post(runnable)
            }

        }, 2000L, 2000L)
    }


    private fun initObserver() {
        berandaViewModel.getBerandaNews().observe(this, Observer { data ->
            berandaViewPager.setImage(data)
            view_pagger_indicator.setViewPager(view_pagger)
            berandaAdapter.setListBusiness(data)
            rv_main.visible()
        })
        berandaViewModel.isLoading().observe(this, Observer { isLoading ->
            isLoading.let {
                progress_bar.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    view_pagger.invisible()
                } else {
                    view_pagger.visible()
                }
            }
        })
    }

//    override fun onStop() {
//        super.onStop()
//        timer?.cancel()
//    }

    override fun onResume() {
        super.onResume()
        timer = null
        timer = Timer()
    }

    override fun onActionSelected(actionItem: SpeedDialActionItem?): Boolean {
        when (actionItem?.id) {
            R.id.technologyFragment -> {
                val action = BerandaFragmentDirections.toTech()
                view?.let {
                    Navigation.findNavController(it).navigate(action)
                }
            }
            R.id.byussinesFragment -> {
                val action = BerandaFragmentDirections.toBusiness()
                view?.let {
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
        return false
    }
}
