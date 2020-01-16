package com.dolan.aiportalberita.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dolan.aiportalberita.model.ArticlesItem

@Database(entities = [ArticlesItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}