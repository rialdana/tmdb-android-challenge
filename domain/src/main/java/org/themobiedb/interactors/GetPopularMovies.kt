package org.themobiedb.interactors

import org.themobiedb.data.repository.MoviesRepository

class GetPopularMovies(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.fetchPopularMovies()
}