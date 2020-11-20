package org.themoviedb.framework.di

import org.koin.dsl.module
import org.themobiedb.core.framework.data.MoviesDataSource
import org.themobiedb.core.framework.data.MoviesRepository
import org.themobiedb.core.interactors.GetPopularMovies
import org.themobiedb.core.interactors.GetTopRatedMovies
import org.themoviedb.framework.data.network.RemoteMoviesDataSource
import org.themoviedb.framework.data.network.TmdbApiService
import org.themoviedb.framework.data.repository.MoviesRepositoryImpl

val appModule = module {

    fun createRepository(remoteDataSource: MoviesDataSource): MoviesRepository {
        return MoviesRepositoryImpl(remoteDataSource)
    }

    fun createDataSource(apiService: TmdbApiService): MoviesDataSource {
        return RemoteMoviesDataSource(apiService)
    }

    single { createDataSource(get()) }
    single { createRepository(get()) }


    factory { GetPopularMovies(get()) }
    factory { GetTopRatedMovies(get()) }
}
