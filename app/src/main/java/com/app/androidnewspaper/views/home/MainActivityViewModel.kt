package com.app.androidnewspaper.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.androidnewspaper.datas.models.ArticleModel
import com.app.androidnewspaper.datas.repository.ArticleRepository

class MainActivityViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    init {
        articleRepository.loadMostPopularArticle()
    }

    fun getProgressBar(): LiveData<Boolean> {
        return articleRepository.isSubscribe()
    }

    fun isError(): LiveData<Boolean> {
        return articleRepository.isError()
    }

    fun getMostPopularArticle(): LiveData<List<ArticleModel>> {
        return articleRepository.getMostPopularArticle()
    }

}