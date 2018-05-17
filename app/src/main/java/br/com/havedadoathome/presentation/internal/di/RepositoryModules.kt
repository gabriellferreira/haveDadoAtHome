package br.com.havedadoathome.presentation.internal.di

import br.com.havedadoathome.data.repository.NewsDataRepository
import br.com.havedadoathome.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModules {

    @Provides
    fun provideNewsRepository(repository: NewsDataRepository): NewsRepository = repository
}