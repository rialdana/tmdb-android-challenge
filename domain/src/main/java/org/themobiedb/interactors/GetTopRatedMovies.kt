package org.themobiedb.interactors

import org.themobiedb.data.repository.MoviesRepository

class GetTopRatedMovies(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() = moviesRepository.fetchTopRatedMovies()
}