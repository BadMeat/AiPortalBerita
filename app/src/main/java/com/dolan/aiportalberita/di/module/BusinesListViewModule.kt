package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModel
import com.dolan.aiportalberita.di.scope.ViewModelKey
import com.dolan.aiportalberita.viewmodel.BusinessListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BusinesListViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(BusinessListViewModel::class)
    internal abstract fun bindBusinesListViewModel(viewModel: BusinessListViewModel): ViewModel
}