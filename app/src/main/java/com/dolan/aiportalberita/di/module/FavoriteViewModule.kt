package com.dolan.aiportalberita.di.module

import androidx.lifecycle.ViewModel
import com.dolan.aiportalberita.di.scope.ViewModelKey
import com.dolan.aiportalberita.viewmodel.FavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FavoriteViewModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    abstract fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel): ViewModel

}