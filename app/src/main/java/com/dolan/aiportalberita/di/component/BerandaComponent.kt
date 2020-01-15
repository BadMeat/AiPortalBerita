package com.dolan.aiportalberita.di.component

import com.dolan.aiportalberita.di.module.BerandaViewModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.BerandaFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [ViewModelFactoryModule::class, BerandaViewModule::class])
interface BerandaComponent {

    fun inject(fragment: BerandaFragment)
}