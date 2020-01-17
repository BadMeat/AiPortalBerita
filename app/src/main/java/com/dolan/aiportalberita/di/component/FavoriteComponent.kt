package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.FavoriteViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.FavoriteFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        FavoriteViewModule::class
    ]
)
interface FavoriteComponent {

    fun inject(favoriteFragment: FavoriteFragment)

}