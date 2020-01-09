package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.TechnologyViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.TechnologyFragment
import dagger.Subcomponent

/**
 * Created by Bencoleng on 08/01/2020.
 */
@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        TechnologyViewModule::class
    ]
)
interface TechnologyComponent {
    fun inject(technologyFragment: TechnologyFragment)
}