package com.dolan.aiportalberita.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.di.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

class BusinessListViewModel @Inject constructor(private val useCase: NewsUseCase) :
    BaseViewModel() {

    private val listBusines = MutableLiveData<List<ArticlesItem>>()

    fun getBusinesList() {
        if (listBusines.value != null) {
            return
        }

        val disposable = useCase.getBusinessRepo()
            .subscribe {
                it?.let {
                    listBusines.value = it
                }
            }

        compositeDisposable.add(disposable)
    }

    fun getBusinessLiveList() = listBusines
}