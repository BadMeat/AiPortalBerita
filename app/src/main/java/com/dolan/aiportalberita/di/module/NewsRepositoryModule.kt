package com.dolan.aiportalberita.di.module

import com.dolan.aiportalberita.di.scope.AppScope
import com.dolan.aiportalberita.repository.BusinessRepository
import com.dolan.aiportalberita.service.BusinesService
import dagger.Module
import dagger.Provides

@Module
class NewsRepositoryModule {

    @AppScope
    @Provides
    fun provideRepository(api: BusinesService) = BusinessRepository(api)
}