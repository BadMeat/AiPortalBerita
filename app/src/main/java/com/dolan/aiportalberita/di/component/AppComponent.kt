package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.NewsRepositoryModule
import com.dolan.aiportalberita.di.module.NewsUseCaseModule
import com.dolan.aiportalberita.di.scope.AppScope
import com.dolan.aiportalberita.network.NetworkModule
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        NewsUseCaseModule::class,
        NewsRepositoryModule::class]
)
interface AppComponent {
    fun newBussinesListComponent(): BussinesListComponent
    fun newTechnologyComponent(): TechnologyComponent

}