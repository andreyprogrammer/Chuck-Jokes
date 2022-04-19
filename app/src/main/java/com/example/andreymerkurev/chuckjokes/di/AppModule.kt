package com.example.andreymerkurev.chuckjokes.di

import com.example.andreymerkurev.chuckjokes.data.datasourse.NetworkDatasource
import com.example.andreymerkurev.chuckjokes.data.repository.JokesRepositoryImpl
import com.example.andreymerkurev.chuckjokes.domain.repository.JokesRepository
import com.example.andreymerkurev.chuckjokes.presentation.jokes.JokesViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun provideNetworkDatasource(): NetworkDatasource =
        NetworkDatasource()

    @Provides
    fun provideJokesRepository(
        network: NetworkDatasource
    ): JokesRepository = JokesRepositoryImpl(network)

    @Singleton
    @Provides
    fun provideJokesViewModelFactory(
        jokesRepository: JokesRepository,
    ): JokesViewModelFactory = JokesViewModelFactory(jokesRepository)
}