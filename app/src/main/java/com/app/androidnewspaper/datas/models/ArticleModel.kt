package com.app.androidnewspaper.datas.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class ArticleModel(
    val uri: String,
    val url: String,
    val id: Long,
    val asset_id: Long,
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
    val abstract: String,
    val media: List<MediaModel> = listOf()
)

@Serializable
class MediaModel(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyright: String,
    val approved_for_syndication: Int,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetaData> = listOf()
)

@Serializable
class MediaMetaData(
    val url: String,
    val format: String,
    val height: Int,
    val width: Int
)

class ArticleResponse(
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results: List<ArticleModel> = listOf()
)
