package com.dolan.aiportalberita.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.db.room.AppDatabase
import com.dolan.aiportalberita.model.ArticlesItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val db: AppDatabase
) : BaseViewModel() {

    private val favoriteList = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getFavoriteRemote() {
        isLoading.value = true
        launch {
            favoriteList.value = db.favoriteDao().select()
        }
        isLoading.value = false
    }

    fun getfavoriteList() = favoriteList
    fun isLoading() = isLoading
}