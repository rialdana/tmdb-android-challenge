package org.themoviedb.network

import org.themoviedb.network.model.movie.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TmdbApiService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("movie/popular")
    suspend fun fetchPopularMovies(@Query("api_key") apiKey: String): MoviesResponse

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("movie/top_rated")
    suspend fun fetchTopRatedMovies(@Query("api_key") apiKey: String): MoviesResponse

}