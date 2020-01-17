package com.dolan.aiportalberita.di.module

import android.content.Context
import com.dolan.aiportalberita.SharedPreferencesHelper
import com.dolan.aiportalberita.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(val context: Context) {

    @AppScope
    @Provides
    fun providePreferences() = SharedPreferencesHelper(context.applicationContext)
}