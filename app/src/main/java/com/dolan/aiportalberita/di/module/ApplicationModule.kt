package com.dolan.aiportalberita.di.module

import android.app.Application
import com.dolan.aiportalberita.db.room.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    @ApplicationContext
    fun provideContext() = application

    @Provides
    @Singleton
    fun provideApplication(): Application = application
}
