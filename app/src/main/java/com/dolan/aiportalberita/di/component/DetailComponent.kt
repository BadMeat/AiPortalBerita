package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.DetailViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.DetailFragment
import dagger.Subcomponent

/**
 * Created by Bencoleng on 20/01/2020.
 */
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        DetailViewModule::class]
)
@FragmentScope
interface DetailComponent {

    fun inject(mainActivity: DetailFragment)
}