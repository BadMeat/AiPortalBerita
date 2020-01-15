package com.dolan.aiportalberita

import android.app.Application
import com.dolan.aiportalberita.di.component.AppComponent
import com.dolan.aiportalberita.di.component.DaggerAppComponent
import com.dolan.aiportalberita.di.module.DatabaseModule
import com.dolan.aiportalberita.di.module.NewsRepositoryModule
import com.dolan.aiportalberita.di.module.NewsUseCaseModule
import com.dolan.aiportalberita.network.NetworkModule

class BaseApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger() =
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .newsRepositoryModule(NewsRepositoryModule())
            .newsUseCaseModule(NewsUseCaseModule())
            .databaseModule(DatabaseModule(this))
            .build()
}