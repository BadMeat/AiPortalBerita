package com.dolan.aiportalberita.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

class BusinessListViewModel @Inject constructor(private val useCase: NewsUseCase) :
    BaseViewModel() {

    private val listBusines = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getBusinessList() {
        isLoading.value = true

        val disposable = useCase.getBusinessRepo()
            .doFinally {
                isLoading.value = false
            }
            .subscribe {
                it?.let {
                    listBusines.value = it
                }
            }

        compositeDisposable.add(disposable)
    }

    fun getBusinessLiveList() = listBusines
    fun getLoading() = isLoading
}