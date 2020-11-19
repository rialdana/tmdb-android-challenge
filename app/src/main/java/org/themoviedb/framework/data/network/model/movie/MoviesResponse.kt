package org.themoviedb.framework.data.network.model.movie


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)