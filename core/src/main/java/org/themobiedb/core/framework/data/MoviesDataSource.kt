package org.themobiedb.core.framework.data

import org.themobiedb.core.framework.Result

interface MoviesDataSource {

    suspend fun fetchPopularMovies(): Result<Any>

    suspend fun fetchTopRatedMovies(): Result<Any>

}