package com.app.androidnewspaper.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.androidnewspaper.datas.models.ArticleModel
import com.app.androidnewspaper.datas.repository.ArticleRepository

class MainActivityViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    init {
        articleRepository.loadMostPopularArticle()
    }

    fun getMostPopularArticle(): LiveData<List<ArticleModel>> {
        return articleRepository.getMostPopularArticle()
    }

}