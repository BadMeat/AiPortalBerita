package com.dolan.aiportalberita.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.SharedPreferencesHelper
import com.dolan.aiportalberita.db.room.AppDatabase
import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class BerandaViewModel @Inject constructor(
    private val useCase: NewsUseCase,
    private val db: AppDatabase,
    private val pref: SharedPreferencesHelper
) : BaseViewModel() {

    private val berandaNewsList = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()
    private val refreshTime = 5 * 60 * 1000 * 1000 * 1000L

    fun refresh() {
        val refresh = pref.getUpdateTime()
        if (refresh != null && refresh != 0L && System.nanoTime() - refresh < refreshTime) {
            fetchFromLocal()
        } else {
            getBerandaNewsRemote()
        }
    }

    private fun fetchFromLocal() {
        isLoading.value = true
        launch {
            val result = db.favoriteDao().select()
            retrieve(result)
        }
    }

    private fun getBerandaNewsRemote() {
        isLoading.value = true
        val disposable = useCase.getBerandaNews()
            .doFinally {
                isLoading.value = false
            }
            .subscribe(
                { result ->
                    berandaNewsList.value = result
                    saveLocally(result)
                },
                { onError -> Log.e("ERROR", "$onError") }
            )

        compositeDisposable.add(disposable)
    }

    private fun saveLocally(articlesItem: List<ArticlesItem>) {
        launch {
            val dao = db.favoriteDao()
            dao.delete()
            val result = dao.insert(*articlesItem.toTypedArray())
            var i = 0
            while (i < result.size) {
                articlesItem[i].uuid = result[i].toInt()
                i++
            }
            retrieve(articlesItem)
        }
        pref.saveUpdateTime(System.nanoTime())
    }

    private fun retrieve(articlesItem: List<ArticlesItem>) {
        berandaNewsList.value = articlesItem
        isLoading.value = false
    }

    fun getBerandaNews() = berandaNewsList
    fun isLoading() = isLoading

}