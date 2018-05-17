package br.com.havedadoathome.data.network.service

import br.com.havedadoathome.data.model.NewsListData
import io.reactivex.Observable
import retrofit2.http.GET

interface NewsService {

    @GET("mostviewed/World/1.json")
    fun getLatestNews(): Observable<NewsListData>
}