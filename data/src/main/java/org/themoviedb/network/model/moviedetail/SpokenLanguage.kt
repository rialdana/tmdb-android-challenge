package org.themoviedb.network.model.moviedetail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.themobiedb.model.moviedetail.SpokenLanguage
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class SpokenLanguage(
    @Json(name = "english_name")
    val englishName: String,
    @Json(name = "iso_639_1")
    val iso6391: String,
    val name: String
) : DomainMapper<SpokenLanguage> {
    override fun mapToDomainModel() = SpokenLanguage(englishName, iso6391, name)

}