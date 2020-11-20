package org.themoviedb.network

import org.themoviedb.network.model.movie.MoviesResponse
import org.themoviedb.network.model.moviedetail.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("movie/popular")
    suspend fun fetchPopularMovies(@Query("api_key") apiKey: String): MoviesResponse

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("movie/top_rated")
    suspend fun fetchTopRatedMovies(@Query("api_key") apiKey: String): MoviesResponse

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("movie/{movie_id}}")
    suspend fun fetchMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): MovieDetailResponse

}