package org.themobiedb.core.interactors

import org.themobiedb.core.framework.data.MoviesRepository

class GetPopularMovies(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.fetchPopularMovies()
}