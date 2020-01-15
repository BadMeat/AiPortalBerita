package com.dolan.aiportalberita.domain

import com.dolan.aiportalberita.model.ArticlesItem
import com.dolan.aiportalberita.repository.BusinessRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsUseCase(private val repository: BusinessRepository) {

    fun getBusinessRepo(): Observable<List<ArticlesItem>> = repository.getBusiness()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.articles
        }

    fun getTechnologyRepo(): Observable<List<ArticlesItem>> = repository.getTechnology()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.articles
        }

    fun getBerandaNews(): Observable<List<ArticlesItem>> = repository.getBerandaNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map {
            it.articles
        }
}