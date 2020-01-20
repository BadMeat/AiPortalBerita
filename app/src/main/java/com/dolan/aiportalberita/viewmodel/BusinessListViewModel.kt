package com.dolan.aiportalberita.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

class BusinessListViewModel @Inject constructor(private val useCase: NewsUseCase) :
    BaseViewModel() {

    private val listBusiness = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getBusinessList() {
        isLoading.value = true

        val disposable = useCase.getBusinessRepo()
            .doFinally {
                isLoading.value = false
            }
            .subscribe(
                { onNext ->
                    onNext?.let {
                        listBusiness.value = onNext
                    }
                },
                { onError ->
                    Log.e("ERROR", "$onError")
                }
            )

        compositeDisposable.add(disposable)
    }

    fun getBusinessLiveList() = listBusiness
    fun getLoading() = isLoading
}