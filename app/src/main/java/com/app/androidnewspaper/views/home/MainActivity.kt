package com.app.androidnewspaper.views.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
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

        viewModel.getProgressBar().observe(this, Observer {
            if (it) {
                findViewById<ProgressBar>(R.id._progressBar).visibility = View.VISIBLE
            } else {
                findViewById<ProgressBar>(R.id._progressBar).visibility = View.GONE
            }
        })

        viewModel.isError().observe(this, Observer {
            if (it)
                Toast.makeText(baseContext, "An error occurred while retrieving items.", Toast.LENGTH_LONG).show()
        })

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