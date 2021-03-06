package br.com.havedadoathome.data.mapper

import br.com.havedadoathome.data.model.NewsListData
import br.com.havedadoathome.domain.model.News
import javax.inject.Inject

class NewsListDomainMapper @Inject constructor(private val newsDataMapper: NewsDomainMapper) {

    fun map(newsListData: NewsListData): List<News>{
        val mutableList = mutableListOf<News>()
        newsListData.results?.map { mutableList.add(newsDataMapper.map(it)) }
        return mutableList
    }
}