package br.com.havedadoathome.presentation.presenter

import br.com.havedadoathome.baseclean.presentation.view.MainContract
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(), MainContract.Presenter
