package com.app.androidnewspaper.views.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.androidnewspaper.R
import com.app.androidnewspaper.adapters.ArticleAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModel()

    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialRecyclerView()

        viewModel.getMostPopularArticle().observe(this, Observer {
            this.adapter.articleList = it
            this.adapter.notifyDataSetChanged()
        })
    }

    private fun initialRecyclerView() {
        val popularArticleList = findViewById<RecyclerView>(R.id._popularArticleList)

        adapter = ArticleAdapter()
        popularArticleList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        popularArticleList.adapter = adapter
    }
}