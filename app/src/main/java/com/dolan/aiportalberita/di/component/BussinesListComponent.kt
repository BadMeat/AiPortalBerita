package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.BusinesListViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.ByussinesFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        BusinesListViewModule::class
    ]
)
interface BussinesListComponent {
    fun inject(bussinesFragment: ByussinesFragment)
}