package br.com.havedadoathome.presentation.presenter

import br.com.havedadoathome.presentation.view.SplashContract
import javax.inject.Inject

class SplashPresenter @Inject constructor() : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun onInitialize() {
        view?.redirectMain()
    }
}
