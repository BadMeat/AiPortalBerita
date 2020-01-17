package com.dolan.aiportalberita.di.module

import android.content.Context
import androidx.room.Room
import com.dolan.aiportalberita.db.room.AppDatabase
import com.dolan.aiportalberita.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(val context: Context) {

    private val dbName = "favorite.db"

    @AppScope
    @Provides
    fun provideDataBase(): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }
}