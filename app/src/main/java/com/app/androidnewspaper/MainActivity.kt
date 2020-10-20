package com.app.androidnewspaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.androidnewspaper.datas.models.ArticleResponse
import com.app.androidnewspaper.datas.services.NYTimeService
import com.app.androidnewspaper.datas.services.ServiceObject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service: NYTimeService = ServiceObject.retrofit.create(NYTimeService::class.java)

        service.getMostPopularArticle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<ArticleResponse> {
                override fun onComplete() = Unit

                override fun onSubscribe(d: Disposable?) = Unit

                override fun onNext(t: ArticleResponse?) {
                    Log.d("Debug", t?.results?.size.toString())
                }

                override fun onError(e: Throwable?) = Unit
            })

    }
}