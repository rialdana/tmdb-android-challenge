package org.themoviedb.framework.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.themoviedb.ui.movies.MoviesViewModel

val viewModelModule = module {
    viewModel {
        MoviesViewModel(get(), get())
    }
}