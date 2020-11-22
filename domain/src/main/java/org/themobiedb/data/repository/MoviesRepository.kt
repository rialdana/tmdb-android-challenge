package org.themobiedb.data.repository

import org.themobiedb.data.Result
import org.themobiedb.model.moviedetail.MovieDetail
import org.themobiedb.model.movies.Movie
import org.themobiedb.model.movies.Movies

interface MoviesRepository {

    suspend fun fetchPopularMovies(): Result<List<Movie>>

    suspend fun fetchTopRatedMovies(): Result<List<Movie>>

    suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail>

    suspend fun searchMovie(query: String): Result<Movies>
}