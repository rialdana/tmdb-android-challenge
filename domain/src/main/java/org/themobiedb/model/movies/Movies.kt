package org.themobiedb.model.movies

import org.themobiedb.model.movies.Movie

data class Movies(
    val page: Int,
    val results: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)