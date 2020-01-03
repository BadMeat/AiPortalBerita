package com.dolan.aiportalberita.service

import com.dolan.aiportalberita.BuildConfig
import com.dolan.aiportalberita.model.ResponseBusines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinesService {

    @GET("top-headlines")
    fun getBusinessNews(
        @Query("country") country: String = "id",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<ResponseBusines>
}