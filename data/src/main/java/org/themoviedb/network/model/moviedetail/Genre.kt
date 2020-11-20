package org.themoviedb.network.model.moviedetail


import com.squareup.moshi.JsonClass
import org.themobiedb.model.moviedetail.Genre
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class Genre(
    val id: Int,
    val name: String
) : DomainMapper<Genre> {
    override fun mapToDomainModel() = Genre(id, name)

}