package com.dolan.aiportalberita.di.module

import android.content.Context
import androidx.room.Room
import com.dolan.aiportalberita.db.room.AppDatabase
import com.dolan.aiportalberita.db.room.ApplicationContext
import com.dolan.aiportalberita.db.room.DatabaseInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(@ApplicationContext val context: Context) {

    @DatabaseInfo
    private val dbName = "favorite.db"

    @Provides
    fun provideDataBase(): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDbName() = dbName

    @Singleton
    @Provides
    fun provideFavoriteDao(appDatabase: AppDatabase) = appDatabase.favoriteDao()
}