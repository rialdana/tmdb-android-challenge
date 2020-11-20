package org.themoviedb.framework.data.network

import org.themobiedb.core.domain.movies.Movies
import org.themobiedb.core.framework.Result
import org.themobiedb.core.framework.data.MoviesDataSource
import org.themoviedb.framework.utils.TMDB_API_KEY

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