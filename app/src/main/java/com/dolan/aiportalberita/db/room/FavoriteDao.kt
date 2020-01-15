package com.dolan.aiportalberita.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dolan.aiportalberita.db.model.Favorite

@Dao
interface FavoriteDao {

    @Insert
    suspend fun insert(vararg favorite: Favorite): List<Long>

    @Query("select * from Favorite")
    suspend fun select(): List<Favorite>
}