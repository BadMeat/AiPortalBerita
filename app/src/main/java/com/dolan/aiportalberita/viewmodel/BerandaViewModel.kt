package com.dolan.aiportalberita.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.db.model.Favorite
import com.dolan.aiportalberita.db.room.AppDatabase
import com.dolan.aiportalberita.domain.NewsUseCase
import com.dolan.aiportalberita.model.ArticlesItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class BerandaViewModel @Inject constructor(
    private val useCase: NewsUseCase,
    private val db: AppDatabase
) : BaseViewModel() {

    private val berandaNewsList = MutableLiveData<List<ArticlesItem>>()
    private val isLoading = MutableLiveData<Boolean>()

    fun getBerandaNewsRemote() {
        isLoading.value = true
        val disposable = useCase.getBerandaNews()
            .doFinally {
                isLoading.value = false
            }
            .subscribe {
                berandaNewsList.value = it
            }

        compositeDisposable.add(disposable)
//        launch {
//            db.favoriteDao().insert(Favorite(3, "ASDAS", "ASDASDSA", "ADSAADs"))
//        }
        launch {
            Log.d("INIDATABNUAAAA", "${db.favoriteDao().select()}")
        }
    }

    fun getBerandaNews() = berandaNewsList
    fun isLoading() = isLoading

}