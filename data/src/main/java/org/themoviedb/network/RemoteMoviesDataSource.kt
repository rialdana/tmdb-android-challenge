package org.themoviedb.network

import org.themobiedb.core.domain.movies.Movies
import org.themobiedb.core.framework.Result
import org.themobiedb.core.framework.data.MoviesDataSource

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

}