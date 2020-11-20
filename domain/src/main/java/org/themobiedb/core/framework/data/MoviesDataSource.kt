package org.themobiedb.core.framework.data

import org.themobiedb.core.domain.movies.Movies
import org.themobiedb.core.framework.Result

interface MoviesDataSource {

    suspend fun fetchPopularMovies(): Result<Movies>

    suspend fun fetchTopRatedMovies(): Result<Movies>

}