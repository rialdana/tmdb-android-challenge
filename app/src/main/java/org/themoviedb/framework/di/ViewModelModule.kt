package org.themoviedb.framework.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.themoviedb.ui.moviedetail.MovieDetailViewModel
import org.themoviedb.ui.movies.MoviesViewModel
import org.themoviedb.ui.searchmovie.SearchMovieViewModel

val viewModelModule = module {
    viewModel {
        MoviesViewModel(get(), get())
    }

    viewModel { (movieId: Int) ->
        MovieDetailViewModel(get(), movieId)
    }

    viewModel { (query: String) ->
        SearchMovieViewModel(get(), query)
    }
}