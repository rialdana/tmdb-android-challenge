package org.themobiedb.interactors

import org.themobiedb.data.repository.MoviesRepository

class GetMovieDetail(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movieId: Int) = moviesRepository.fetchMovieDetail(movieId)
}