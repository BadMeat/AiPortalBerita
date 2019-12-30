package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModelProvider
import com.dolan.aiportalberita.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}