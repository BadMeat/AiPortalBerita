package com.dolan.aiportalberita.di.domain

import com.dolan.aiportalberita.repository.BusinesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsUseCase(private val repository: BusinesRepository) {

    fun getBusinessRepo() = repository.getBusines()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}