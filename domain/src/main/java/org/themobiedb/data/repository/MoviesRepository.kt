package org.themobiedb.data.repository

import org.themobiedb.data.Result
import org.themobiedb.model.moviedetail.MovieDetail
import org.themobiedb.model.movies.Movies

interface MoviesRepository {

    suspend fun fetchPopularMovies(): Result<Movies>

    suspend fun fetchTopRatedMovies(): Result<Movies>

    suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail>

    suspend fun searchMovie(query: String): Result<Movies>
}