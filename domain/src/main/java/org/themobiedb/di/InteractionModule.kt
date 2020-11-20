package org.themobiedb.di

import org.koin.dsl.module
import org.themobiedb.interactors.GetMovieDetail
import org.themobiedb.interactors.GetPopularMovies
import org.themobiedb.interactors.GetTopRatedMovies

val interactionModule = module {
    factory { GetPopularMovies(get()) }
    factory { GetTopRatedMovies(get()) }
    factory { GetMovieDetail(get()) }
}