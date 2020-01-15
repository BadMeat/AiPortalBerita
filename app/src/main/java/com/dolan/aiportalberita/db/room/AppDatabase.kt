package com.dolan.aiportalberita.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dolan.aiportalberita.db.model.Favorite

@Database(entities = [Favorite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}