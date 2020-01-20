package com.dolan.aiportalberita.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity
data class ArticlesItem(

    @field:SerializedName("publishedAt")
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null,

    @field:SerializedName("author")
    @ColumnInfo(name = "author")
    var author: String? = null,

    @field:SerializedName("urlToImage")
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null,

    @field:SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String? = null,

    @field:SerializedName("source")
    @Ignore
    var source: Source? = null,

    @field:SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String? = null,

    @field:SerializedName("url")
    @ColumnInfo(name = "url")
    var url: String? = null,

    @field:SerializedName("content")
    @ColumnInfo(name = "content")
    var content: String? = null
) : Parcelable {
    @IgnoredOnParcel
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}