package br.com.havedadoathome.domain.repository

import br.com.havedadoathome.domain.model.News
import io.reactivex.Observable

interface NewsRepository {
    fun fetchLatestNews(): Observable<List<News>>
}