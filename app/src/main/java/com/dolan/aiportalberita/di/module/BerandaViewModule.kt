package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModel
import com.dolan.aiportalberita.di.scope.ViewModelKey
import com.dolan.aiportalberita.viewmodel.BerandaViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BerandaViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(BerandaViewModel::class)
    abstract fun bindsBerandaViewModel(berandaViewModel: BerandaViewModel): ViewModel

}