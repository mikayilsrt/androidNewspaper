package com.app.androidnewspaper.datas.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.androidnewspaper.datas.models.ArticleModel
import com.app.androidnewspaper.datas.models.ArticleResponse
import com.app.androidnewspaper.datas.services.NYTimeService
import com.app.androidnewspaper.datas.services.ServiceObject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ArticleRepository {

    private val service: NYTimeService = ServiceObject.retrofit.create(NYTimeService::class.java)

    private val _isSubscribe: MutableLiveData<Boolean> = MutableLiveData()
    fun isSubscribe(): LiveData<Boolean> {
        return this._isSubscribe
    }

    private val _isError: MutableLiveData<Boolean> = MutableLiveData()
    fun isError(): LiveData<Boolean> {
        return this._isError
    }

    private val _mostPopularArticle: MutableLiveData<List<ArticleModel>> = MutableLiveData()
    fun getMostPopularArticle(): LiveData<List<ArticleModel>> {
        return this._mostPopularArticle
    }

    fun loadMostPopularArticle() {
        service.getMostPopularArticle()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: Observer<ArticleResponse> {
                override fun onComplete() {
                    this@ArticleRepository._isSubscribe.value = false
                }

                override fun onSubscribe(d: Disposable?) {
                    this@ArticleRepository._isSubscribe.value = true
                }

                override fun onNext(t: ArticleResponse) {
                    this@ArticleRepository._mostPopularArticle?.value = t.results
                }

                override fun onError(e: Throwable?) {
                    this@ArticleRepository._isError.value = true
                    this@ArticleRepository._isSubscribe.value = false
                }
            })
    }

}