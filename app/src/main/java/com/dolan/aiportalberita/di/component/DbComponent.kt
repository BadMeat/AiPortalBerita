package com.dolan.aiportalberita.di.component

import android.app.Application
import android.content.Context
import com.dolan.aiportalberita.db.room.ApplicationContext
import com.dolan.aiportalberita.db.room.DatabaseInfo
import com.dolan.aiportalberita.di.module.ApplicationModule
import com.dolan.aiportalberita.di.module.DatabaseModule
import com.dolan.aiportalberita.di.module.ViewModelFactoryModule
import com.dolan.aiportalberita.di.scope.FragmentScope
import com.dolan.aiportalberita.ui.BerandaFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ApplicationModule::class,
        DatabaseModule::class,
        ViewModelFactoryModule::class]
)
interface DbComponent {

    fun inject(berandaFragment: BerandaFragment)

    @ApplicationContext
    fun getContext(): Context

    fun getAppplication(): Application

    @DatabaseInfo
    fun getDbName(): String

}