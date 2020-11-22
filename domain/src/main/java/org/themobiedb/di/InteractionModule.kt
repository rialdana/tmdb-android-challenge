package org.themobiedb.di

import org.koin.dsl.module
import org.themobiedb.interactors.GetMovieDetail
import org.themobiedb.interactors.GetPopularMovies
import org.themobiedb.interactors.GetTopRatedMovies
import org.themobiedb.interactors.SearchMovies

val interactionModule = module {
    factory { GetPopularMovies(get()) }
    factory { GetTopRatedMovies(get()) }
    factory { GetMovieDetail(get()) }
    factory { SearchMovies(get()) }
}