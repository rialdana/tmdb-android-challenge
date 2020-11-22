package org.themoviedb.network.model.moviedetail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.themobiedb.model.moviedetail.BelongsToCollection
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class BelongsToCollection(
    @Json(name = "backdrop_path")
    val backdropPath: String,
    val id: Int,
    val name: String,
    @Json(name = "poster_path")
    val posterPath: String
) : DomainMapper<BelongsToCollection> {
    override fun mapToDomainModel() = BelongsToCollection(backdropPath, id, name, posterPath)

}