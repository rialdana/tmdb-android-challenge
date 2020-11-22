package org.themobiedb.model.movies

data class Movie(
    val id: Int,
    val overview: String,
    val posterPath: String,
    val title: String
)