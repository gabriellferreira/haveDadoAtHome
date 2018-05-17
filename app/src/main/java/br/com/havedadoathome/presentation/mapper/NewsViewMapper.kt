package br.com.havedadoathome.presentation.mapper

import br.com.havedadoathome.domain.model.News
import br.com.havedadoathome.presentation.model.NewsViewModel
import javax.inject.Inject

class NewsViewMapper @Inject constructor() : BaseViewMapper() {

    fun map(news: News) =
            NewsViewModel(url = news.url,
                    column = news.column,
                    section = news.section,
                    title = news.title,
                    source = news.source,
                    publishedDate = news.publishedDate,
                    mediaUrl = news.mediaUrl,
                    mediaCaption = news.mediaCaption)
}