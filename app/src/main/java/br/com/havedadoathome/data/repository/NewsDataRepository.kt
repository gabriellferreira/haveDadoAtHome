package br.com.havedadoathome.data.repository

import br.com.havedadoathome.data.mapper.NewsListDomainMapper
import br.com.havedadoathome.data.network.api.NewsApi
import br.com.havedadoathome.domain.model.News
import br.com.havedadoathome.domain.repository.NewsRepository
import io.reactivex.Observable
import javax.inject.Inject

class NewsDataRepository @Inject constructor(private val newsApi: NewsApi,
                                             private val newsListDomainMapper: NewsListDomainMapper) : NewsRepository {

    override fun fetchLatestNews(): Observable<List<News>> =
            newsApi.getLatestNews().map { newsListDomainMapper.map(it) }
}