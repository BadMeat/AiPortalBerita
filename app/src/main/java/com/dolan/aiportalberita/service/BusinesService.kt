package com.dolan.aiportalberita.service

import com.dolan.aiportalberita.BuildConfig
import com.dolan.aiportalberita.model.ResponseNews
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinesService {

    @GET("top-headlines")
    fun getRemoteNews(
        @Query("country") country: String = "id",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<ResponseNews>

    @GET("top-headlines")
    fun getBerandaNews(
        @Query("country") country: String = "id",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Observable<ResponseNews>
}