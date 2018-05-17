@file:Suppress("unused")

package br.com.havedadoathome.domain.model

import br.com.havedadoathome.data.model.BaseDataModel

class News(val url: String,
           val column: String,
           val section: String,
           val title: String,
           val source: String,
           val publishedDate: String,
           val mediaUrl: String,
           val mediaCaption: String) : BaseDataModel()