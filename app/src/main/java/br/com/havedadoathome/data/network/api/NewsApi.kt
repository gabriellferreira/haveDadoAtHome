package br.com.havedadoathome.data.network.api

import br.com.havedadoathome.data.model.NewsListData
import br.com.havedadoathome.data.network.service.NewsService
import io.reactivex.Observable
import javax.inject.Inject

class NewsApi @Inject constructor() : BaseApi() {

    private var newsService: NewsService

    init {
        val retrofit = build()
        newsService = retrofit.create(NewsService::class.java)
    }

    fun getLatestNews(): Observable<NewsListData> = newsService.getLatestNews()
}