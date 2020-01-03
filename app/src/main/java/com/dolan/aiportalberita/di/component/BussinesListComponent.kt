package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.BusinesListViewModule
import com.dolan.aiportalberita.di.module.TechnologyViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.ByussinesFragment
import com.dolan.aiportalberita.ui.TechnologyFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        BusinesListViewModule::class,
        TechnologyViewModule::class
    ]
)
interface BussinesListComponent {
    fun inject(bussinesFragment: ByussinesFragment)
    fun inject(technologyFragment: TechnologyFragment)
}