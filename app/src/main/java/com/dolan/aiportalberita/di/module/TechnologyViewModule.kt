package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModel
import com.dolan.aiportalberita.di.scope.ViewModelKey
import com.dolan.aiportalberita.viewmodel.TechnologyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Bencoleng on 01/01/2020.
 */
@Module
abstract class TechnologyViewModule {


    @Binds
    @IntoMap
    @ViewModelKey(TechnologyViewModel::class)
    abstract fun bindViewModel(viewModel: TechnologyViewModel): ViewModel

}