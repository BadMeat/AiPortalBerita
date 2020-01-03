package com.dolan.aiportalberita.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.di.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

/**
 * Created by Bencoleng on 01/01/2020.
 */
class TechnologyViewModel @Inject constructor(private val useCase: NewsUseCase) : BaseViewModel() {

    private val listTechnology = MutableLiveData<List<ArticlesItem>>()

    fun getRemoteList() {
        val disposable = useCase.getTechnologyRepo()
            .subscribe {
                it?.let {
                    listTechnology.value = it
                }
            }

        compositeDisposable.add(disposable)
    }

    fun getListTechnology() = listTechnology

}