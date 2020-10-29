package com.app.androidnewspaper.datas.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.androidnewspaper.datas.models.ArticleModel
import com.app.androidnewspaper.datas.repository.dao.FavoriteDao

@Database(entities = [ArticleModel::class], version = 1, exportSchema = false)
abstract class ArticleRoomDatabase: RoomDatabase() {

    abstract fun getFavoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleRoomDatabase? = null

        fun getDatabase(context: Context): ArticleRoomDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room
                    .databaseBuilder(context.applicationContext, ArticleRoomDatabase::class.java, "article_database")
                    .build()
                INSTANCE = instance

                return instance
            }
        }
    }

}