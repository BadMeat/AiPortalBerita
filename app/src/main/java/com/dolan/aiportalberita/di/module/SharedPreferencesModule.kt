package com.dolan.aiportalberita.di.module

import android.content.Context
import com.dolan.aiportalberita.SharedPreferencesHelper
import com.dolan.aiportalberita.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class SharedPreferencesModule(val context: Context) {

//    private var pref: SharedPreferences? = null
//
//    private fun buildHelper(context: Context): SharedPreferencesHelper {
//        pref = PreferenceManager.getDefaultSharedPreferences(context)
//        return SharedPreferencesHelper(context)
//    }
//
//    @Volatile
//    private var instance: SharedPreferencesHelper? = null
//
//    @AppScope
//    @Provides
//    fun provideHelper(): SharedPreferencesHelper = instance ?: synchronized(Any()) {
//        instance ?: buildHelper(context).also {
//            instance = it
//        }
//    }

    @AppScope
    @Provides
    fun providePreferences() = SharedPreferencesHelper(context.applicationContext)
}