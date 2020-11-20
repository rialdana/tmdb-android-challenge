package org.themoviedb.network

import org.themobiedb.model.movies.Movies
import org.themobiedb.data.Result
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.model.moviedetail.MovieDetail

class RemoteMoviesDataSource(private val apiService: TmdbApiService) : MoviesDataSource {

    override suspend fun fetchPopularMovies(): Result<Movies> {
        return try {
            val movies = apiService.fetchPopularMovies(TMDB_API_KEY).mapToDomainModel()

            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchTopRatedMovies(): Result<Movies> {
        return try {
            val movies = apiService.fetchTopRatedMovies(TMDB_API_KEY).mapToDomainModel()

            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail> {
        return try {
            val movieDetail = apiService.fetchMovieDetail(movieId, TMDB_API_KEY).mapToDomainModel()

            Result.Success(movieDetail)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}