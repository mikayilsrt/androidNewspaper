package com.app.androidnewspaper.views.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.app.androidnewspaper.R
import com.app.androidnewspaper.datas.repository.ArticleRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articleRepository: ArticleRepository = ArticleRepository()
        articleRepository.loadMostPopularArticle()

        articleRepository.getMostPopularArticle().observe(this, Observer {
            Log.d("Debug", it.size.toString())
        })
    }
}