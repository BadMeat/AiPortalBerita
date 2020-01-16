package com.dolan.aiportalberita.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dolan.aiportalberita.model.ArticlesItem

@Dao
interface FavoriteDao {

    @Insert
    suspend fun insert(vararg article: ArticlesItem): List<Long>

    @Query("select * from ArticlesItem")
    suspend fun select(): List<ArticlesItem>

    @Query("delete from ArticlesItem")
    suspend fun delete()
}