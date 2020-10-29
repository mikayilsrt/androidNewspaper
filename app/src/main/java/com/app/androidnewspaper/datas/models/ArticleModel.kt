package com.app.androidnewspaper.datas.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "article_table")
open class ArticleModel(
    @ColumnInfo(name = "uri") val uri: String,
    @ColumnInfo(name = "url") val url: String,
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "asset_id") val asset_id: Long,
    @ColumnInfo(name = "source") val source: String,
    @ColumnInfo(name = "published_date") val published_date: String,
    @ColumnInfo(name = "updated") val updated: String,
    @ColumnInfo(name = "section") val section: String,
    @ColumnInfo(name = "subsection") val subsection: String,
    @ColumnInfo(name = "nytdsection") val nytdsection: String,
    @ColumnInfo(name = "adx_keywords") val adx_keywords: String,
    @ColumnInfo(name = "column") val column: String? = null,
    @ColumnInfo(name = "byline") val byline: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "abstract") val abstract: String,
    @ColumnInfo(name = "media") val media: List<MediaModel> = listOf()
)

@Serializable
data class MediaModel(
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "subtype") val subtype: String,
    @ColumnInfo(name = "caption") val caption: String,
    @ColumnInfo(name = "copyright") val copyright: String,
    @ColumnInfo(name = "approved_for_syndication") val approved_for_syndication: Int,
    @SerializedName("media-metadata") @ColumnInfo(name = "mediaMetadata") val mediaMetadata: List<MediaMetaData> = listOf()
)

@Serializable
data class MediaMetaData(
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "format") val format: String,
    @ColumnInfo(name = "height") val height: Int,
    @ColumnInfo(name = "width") val width: Int
)

class ArticleResponse(
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results: List<ArticleModel> = listOf()
)
