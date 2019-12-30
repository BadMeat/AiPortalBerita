package com.dolan.aiportalberita.repository

import com.dolan.aiportalberita.model.ResponseBusines
import com.dolan.aiportalberita.service.BusinesService
import io.reactivex.Observable

class BusinesRepository(val businesApi: BusinesService) {

    fun getBusines(): Observable<ResponseBusines> {
        return businesApi.getBusinessNews()
    }
}