package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModel
import com.dolan.aiportalberita.di.scope.ViewModelKey
import com.dolan.aiportalberita.viewmodel.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Bencoleng on 20/01/2020.
 */
@Module
abstract class DetailViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(detailViewModel: DetailViewModel): ViewModel

}