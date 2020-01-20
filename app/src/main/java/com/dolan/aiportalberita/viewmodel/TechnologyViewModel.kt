package com.dolan.aiportalberita.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

/**
 * Created by Bencoleng on 01/01/2020.
 */
class TechnologyViewModel @Inject constructor(private val useCase: NewsUseCase) : BaseViewModel() {

    private val listTechnology = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getRemoteList() {
        isLoading.value = true
        val disposable = useCase.getTechnologyRepo()
            .doFinally {
                isLoading.value = false
            }
            .subscribe(
                { result ->
                    result?.let {
                        listTechnology.value = result
                    }
                },
                { onError -> Log.d("ERROR", "$onError") }
            )
        compositeDisposable.add(disposable)
    }

    fun getListTechnology() = listTechnology
    fun isLoading() = isLoading
}