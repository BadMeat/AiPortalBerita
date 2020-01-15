package com.dolan.aiportalberita.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(

    @ColumnInfo(name = "fav_id")
    var id: Long,
    @ColumnInfo(name = "fav_title")
    var title: String,
    @ColumnInfo(name = "fav_desc")
    var desc: String,
    @ColumnInfo(name = "fav_url")
    var url: String
) {
    @PrimaryKey
    var uuid: Int = 0
}