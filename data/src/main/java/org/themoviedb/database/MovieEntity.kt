package org.themoviedb.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.themobiedb.model.movies.Movie
import org.themoviedb.network.mappers.DomainMapper

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey
    val id: Int,

    val name: String,

    val overview: String,

    val posterPath: String,

    val movieType: Int
) : DomainMapper<Movie> {
    companion object {
        const val POPULAR_MOVIE = 0
        const val TOP_RATED_MOVIE = 1
    }

    override fun mapToDomainModel() = Movie(
        id, overview, posterPath, name
    )
}