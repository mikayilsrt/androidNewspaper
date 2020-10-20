package com.app.androidnewspaper.datas.services

import com.app.androidnewspaper.datas.models.ArticleResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NYTimeService {

    @GET("mostpopular/v2/viewed/1.json?api-key{api-key}")
    fun getMostPopularArticle(
        @Path("api-key") apiKey : String = ServiceObject.apiKey
    ): Observable<ArticleResponse>

}