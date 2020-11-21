package org.themobiedb.interactors

import org.themobiedb.data.repository.MoviesRepository


class SearchMovies(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(query: String) = moviesRepository.searchMovie(query)
}