package org.themoviedb.framework.data.repository

import org.themobiedb.core.framework.Result
import org.themobiedb.core.framework.data.MoviesDataSource
import org.themobiedb.core.framework.data.MoviesRepository

class MoviesRepositoryImpl(private val remoteDataSource: MoviesDataSource) : MoviesRepository {

    override suspend fun fetchPopularMovies(): Result<Any> {
        return remoteDataSource.fetchPopularMovies()
    }

    override suspend fun fetchTopRatedMovies(): Result<Any> {
        return remoteDataSource.fetchTopRatedMovies()
    }

}