package com.app.androidnewspaper.views.article

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.app.androidnewspaper.R
import com.app.androidnewspaper.datas.models.ArticleModel
import kotlinx.serialization.json.Json

class ArticleActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ARTICLE = "EXTRA_ARTICLE"

        fun start(context: Context, articleModel: String) {
            context.startActivity(Intent(context, ArticleActivity::class.java).apply {
                putExtra("EXTRA_ARTICLE", articleModel)
            })
        }
    }

    private val articleModelExtra by lazy {
        Json.parse(ArticleModel.serializer(), intent.getStringExtra("EXTRA_ARTICLE").toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        findViewById<WebView>(R.id._articleWebView).loadUrl(articleModelExtra.url.toString())
    }
}