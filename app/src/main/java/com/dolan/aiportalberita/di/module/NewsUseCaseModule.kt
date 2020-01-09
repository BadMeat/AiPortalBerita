package com.dolan.aiportalberita.di.module

import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.di.scope.AppScope
import com.dolan.aiportalberita.repository.BusinessRepository
import dagger.Module
import dagger.Provides

@Module
class NewsUseCaseModule {

    @AppScope
    @Provides
    fun provideFeedUseCase(repository: BusinessRepository) =
        NewsUseCase(repository)

}