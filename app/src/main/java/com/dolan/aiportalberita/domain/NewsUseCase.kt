package com.dolan.aiportalberita.domain

import com.dolan.aiportalberita.repository.BusinessRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsUseCase(private val repository: BusinessRepository) {

    fun getBusinessRepo() = repository.getBusiness()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.articles
        }

    fun getTechnologyRepo() = repository.getTechnology()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.articles
        }
}