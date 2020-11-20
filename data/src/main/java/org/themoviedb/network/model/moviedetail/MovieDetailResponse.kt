package org.themoviedb.network.model.moviedetail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import org.themobiedb.model.moviedetail.MovieDetail
import org.themoviedb.network.mappers.DomainMapper

@JsonClass(generateAdapter = true)
data class MovieDetailResponse(
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    @Json(name = "imdb_id")
    val imdbId: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompany>,
    @Json(name = "production_countries")
    val productionCountries: List<Any>,
    @Json(name = "release_date")
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
) : DomainMapper<MovieDetail> {
    override fun mapToDomainModel() = MovieDetail(
        adult,
        backdropPath,
        belongsToCollection.mapToDomainModel(),
        budget,
        genres.map { it.mapToDomainModel() },
        homepage,
        id,
        imdbId,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies.map { it.mapToDomainModel() },
        productionCountries,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages.map { it.mapToDomainModel() },
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )

}