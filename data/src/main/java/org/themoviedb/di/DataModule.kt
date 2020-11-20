package org.themoviedb.di

import org.koin.dsl.module
import org.themobiedb.core.framework.data.MoviesDataSource
import org.themobiedb.core.framework.data.MoviesRepository
import org.themoviedb.network.RemoteMoviesDataSource
import org.themoviedb.network.TmdbApiService
import org.themoviedb.repository.MoviesRepositoryImpl

val dataModule = module {

    fun createRepository(remoteDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryImpl(remoteDataSource)
    }

    fun createDataSource(apiService: TmdbApiService): MoviesDataSource {
        return RemoteMoviesDataSource(apiService)
    }

    single { createDataSource(get()) }
    single { createRepository(get()) }
}