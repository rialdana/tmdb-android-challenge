package org.themoviedb.di

import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.data.repository.MoviesRepository
import org.themoviedb.database.MovieDao
import org.themoviedb.network.RemoteMoviesDataSource
import org.themoviedb.network.TmdbApiService
import org.themoviedb.repository.MoviesRepositoryImpl

val dataModule = module {

    fun createRepository(remoteDataSource: MoviesDataSource, movieDao: MovieDao): MoviesRepository {
        return MoviesRepositoryImpl(remoteDataSource, movieDao)
    }

    fun createDataSource(apiService: TmdbApiService): MoviesDataSource {
        return RemoteMoviesDataSource(apiService)
    }

    single { createDataSource(get()) }
    single { createRepository(get(), get()) }
}