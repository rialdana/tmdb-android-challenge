package org.themobiedb.di

import org.koin.dsl.module
import org.themobiedb.core.interactors.GetPopularMovies
import org.themobiedb.core.interactors.GetTopRatedMovies

val interactionModule = module {
    factory { GetPopularMovies(get()) }
    factory { GetTopRatedMovies(get()) }
}