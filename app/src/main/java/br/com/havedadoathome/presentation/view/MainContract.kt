package br.com.havedadoathome.baseclean.presentation.view

import br.com.havedadoathome.presentation.view.BaseContract

interface MainContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
