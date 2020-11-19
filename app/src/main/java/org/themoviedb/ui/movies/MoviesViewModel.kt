package org.themoviedb.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.themobiedb.core.interactors.GetPopularMovies
import org.themobiedb.core.interactors.GetTopRatedMovies

class MoviesViewModel(
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {

    init {

        viewModelScope.launch {
            getTopRatedMovies.invoke()
            getPopularMovies.invoke()
        }
    }
}