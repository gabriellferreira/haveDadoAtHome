package br.com.havedadoathome.presentation.internal.di

import br.com.havedadoathome.presentation.presenter.MainPresenter
import br.com.havedadoathome.presentation.presenter.NewsPresenter
import br.com.havedadoathome.presentation.presenter.SplashPresenter
import br.com.havedadoathome.presentation.view.activity.MainActivity
import br.com.havedadoathome.presentation.view.activity.NewsActivity
import br.com.havedadoathome.presentation.view.activity.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RepositoryModules::class)])
interface AppComponent {

    val appApplication: AppApplication

    // Application
    fun inject(appApplication: AppApplication)

    // Presenter
    fun splashPresenter(): SplashPresenter

    fun mainPresenter(): MainPresenter

    fun newsPresenter(): NewsPresenter

    // View
    fun inject(appApplication: SplashActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(newsActivity: NewsActivity)
}