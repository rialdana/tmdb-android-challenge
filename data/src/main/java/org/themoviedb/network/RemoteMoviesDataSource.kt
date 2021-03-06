package org.themoviedb.network

import org.themobiedb.model.movies.Movies
import org.themobiedb.data.Result
import org.themobiedb.data.datasource.MoviesDataSource
import org.themobiedb.model.moviedetail.MovieDetail

class RemoteMoviesDataSource(private val apiService: TmdbApiService) : MoviesDataSource {

    override suspend fun fetchPopularMovies(): Movies {
        return apiService.fetchPopularMovies(TMDB_API_KEY).mapToDomainModel()
    }

    override suspend fun fetchTopRatedMovies(): Movies {
        return apiService.fetchTopRatedMovies(TMDB_API_KEY).mapToDomainModel()
    }

    override suspend fun fetchMovieDetail(movieId: Int): Result<MovieDetail> {
        return try {
            val movieDetail = apiService.fetchMovieDetail(movieId, TMDB_API_KEY).mapToDomainModel()

            Result.Success(movieDetail)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun searchMovie(query: String): Result<Movies> {
        return try {
            val movies = apiService.searchMovies(TMDB_API_KEY, query).mapToDomainModel()
            Result.Success(movies)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}