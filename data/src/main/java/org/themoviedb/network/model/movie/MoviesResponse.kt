package org.themoviedb.network.model.movie


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.themobiedb.model.movies.Movies
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    val page: Int,
    val results: List<Movie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
) : DomainMapper<Movies> {
    override fun mapToDomainModel() = Movies(
        page, results.map { it.mapToDomainModel() }, totalPages, totalResults
    )
}