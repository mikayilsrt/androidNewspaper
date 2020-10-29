package com.app.androidnewspaper.datas.repository.dao

import androidx.room.*
import com.app.androidnewspaper.datas.models.ArticleModel

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(articleModel: ArticleModel): Unit

    @Delete
    fun delete(articleModel: ArticleModel): Unit

    @Query("SELECT * FROM article_table")
    fun getFavoriteArticles(): List<ArticleModel>

}