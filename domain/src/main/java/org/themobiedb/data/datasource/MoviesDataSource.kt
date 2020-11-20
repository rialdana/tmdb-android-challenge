package org.themobiedb.data.datasource

import org.themobiedb.data.Result
import org.themobiedb.model.moviedetail.MovieDetail
import org.themobiedb.model.movies.Movies

interface MoviesDataSource {

    suspend fun fetchPopularMovies(): Result<Movies>

    suspend fun fetchTopRatedMovies(): Result<Movies>

    suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail>
}