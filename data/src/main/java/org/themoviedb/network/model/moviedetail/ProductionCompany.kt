package org.themoviedb.network.model.moviedetail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.themobiedb.model.moviedetail.ProductionCompany
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class ProductionCompany(
    val id: Int,
    @Json(name = "logo_path")
    val logoPath: String?,
    val name: String,
    @Json(name = "origin_country")
    val originCountry: String
) : DomainMapper<ProductionCompany> {
    override fun mapToDomainModel() = ProductionCompany(id, logoPath ?: "", name, originCountry)

}