package com.dolan.aiportalberita.service

import com.dolan.aiportalberita.model.ResponseBusines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinesService {

    @GET("top-headlines?country=id&category=business&apiKey=6fc7f8811570490fbed93e74108c0bfd")
    fun getBusinessNews(): Observable<ResponseBusines>
}