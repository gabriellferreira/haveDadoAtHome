package br.com.havedadoathome.presentation.internal.di

import android.content.Context
import android.content.SharedPreferences
import br.com.havedadoathome.BuildConfig
import br.com.havedadoathome.presentation.util.connection.DefaultInternetConnectionVerifier
import br.com.havedadoathome.presentation.util.connection.InternetConnectionVerifier
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val appApplication: AppApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = appApplication

    @Provides
    @Singleton
    fun application(): AppApplication = appApplication

    @Provides
    @Singleton
    fun provideInternetConnectionVerifier(context: Context): InternetConnectionVerifier = DefaultInternetConnectionVerifier(context)

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
}