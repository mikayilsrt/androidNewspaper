package com.app.androidnewspaper.datas.models

class ArticleModel(
    val uri: String,
    val url: String,
    val id: Int,
    val asset_id: Int,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val adx_keywords: String,
    val column: String? = null,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String
)

class ArticleResponse(
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results: List<ArticleModel>? = listOf()
)
