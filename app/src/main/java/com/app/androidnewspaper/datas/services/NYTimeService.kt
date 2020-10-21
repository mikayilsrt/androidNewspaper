package com.app.androidnewspaper.datas.services

import com.app.androidnewspaper.datas.models.ArticleResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NYTimeService {

    @GET("mostpopular/v2/viewed/1.json")
    fun getMostPopularArticle(
        @Query("api-key") apiKey: String = ServiceObject.apiKey
    ): Observable<ArticleResponse>

}