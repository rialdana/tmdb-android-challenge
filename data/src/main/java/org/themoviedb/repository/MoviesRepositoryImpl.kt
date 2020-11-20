package org.themoviedb.repository

import org.themobiedb.model.movies.Movies
import org.themobiedb.data.Result
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.data.repository.MoviesRepository

class MoviesRepositoryImpl(private val remoteDataSource: MoviesDataSource) : MoviesRepository {

    override suspend fun fetchPopularMovies(): Result<Movies> {
        return remoteDataSource.fetchPopularMovies()
    }

    override suspend fun fetchTopRatedMovies(): Result<Movies> {
        return remoteDataSource.fetchTopRatedMovies()
    }

}