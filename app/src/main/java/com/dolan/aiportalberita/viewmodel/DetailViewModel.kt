package com.dolan.aiportalberita.viewmodel

import androidx.lifecycle.MutableLiveData
import com.dolan.aiportalberita.model.ArticlesItem
import javax.inject.Inject

/**
 * Created by Bencoleng on 20/01/2020.
 */
class DetailViewModel @Inject constructor() : BaseViewModel() {

    private val article = MutableLiveData<ArticlesItem>()

    fun getData(data: ArticlesItem) {
        article.value = data
    }

    fun getArticle() = article

}