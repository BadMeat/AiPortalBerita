package com.dolan.aiportalberita.repository

import com.dolan.aiportalberita.BUSINESS
import com.dolan.aiportalberita.COUNTRY
import com.dolan.aiportalberita.TECHNOLOGY
import com.dolan.aiportalberita.model.ResponseNews
import com.dolan.aiportalberita.service.BusinesService
import io.reactivex.Observable

class BusinessRepository(val businesApi: BusinesService) {

    fun getBusiness(): Observable<ResponseNews> {
        return businesApi.getRemoteNews(COUNTRY, BUSINESS)
    }

    fun getTechnology(): Observable<ResponseNews> {
        return businesApi.getRemoteNews(COUNTRY, TECHNOLOGY)
    }

    fun getBerandaNews() = businesApi.getBerandaNews()
}