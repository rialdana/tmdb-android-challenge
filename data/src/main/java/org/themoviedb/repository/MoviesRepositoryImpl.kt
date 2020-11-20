package org.themoviedb.repository

import org.themobiedb.core.domain.movies.Movies
import org.themobiedb.core.framework.Result
import org.themobiedb.core.framework.data.MoviesDataSource
import org.themobiedb.core.framework.data.MoviesRepository

class MoviesRepositoryImpl(private val remoteDataSource: MoviesDataSource) : MoviesRepository {

    override suspend fun fetchPopularMovies(): Result<Movies> {
        return remoteDataSource.fetchPopularMovies()
    }

    override suspend fun fetchTopRatedMovies(): Result<Movies> {
        return remoteDataSource.fetchTopRatedMovies()
    }

}