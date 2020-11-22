package org.themoviedb.repository

import org.themobiedb.model.movies.Movies
import org.themobiedb.data.Result
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.data.onFailure
import org.themobiedb.data.onSuccess
import org.themobiedb.data.repository.MoviesRepository
import org.themobiedb.model.moviedetail.MovieDetail
import org.themoviedb.database.MovieDao
import org.themoviedb.database.MovieEntity

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesDataSource,
    private val movieDao: MovieDao
) : MoviesRepository {

    override suspend fun fetchPopularMovies(): Result<Movies> {
        return remoteDataSource.fetchPopularMovies()
    }

    override suspend fun fetchTopRatedMovies(): Result<Movies> {
        return remoteDataSource.fetchTopRatedMovies()
    }

    override suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail> {
        return remoteDataSource.fetchMovieDetail(movieId)
    }

    override suspend fun searchMovie(query: String): Result<Movies> {
        return remoteDataSource.searchMovie(query)
    }

}