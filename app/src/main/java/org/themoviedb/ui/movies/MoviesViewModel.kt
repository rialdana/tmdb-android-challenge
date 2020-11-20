package org.themoviedb.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.themobiedb.model.movies.Movies
import org.themobiedb.data.onFailure
import org.themobiedb.data.onSuccess
import org.themobiedb.interactors.GetPopularMovies
import org.themobiedb.interactors.GetTopRatedMovies

class MoviesViewModel(
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getPopularMovies: GetPopularMovies
) : ViewModel() {

    private val _topRatedMovies = MutableLiveData<Movies>()
    val topRatedMovies: LiveData<Movies>
        get() = _topRatedMovies

    private val _popularMovies = MutableLiveData<Movies>()
    val popularMovies: LiveData<Movies>
        get() = _popularMovies

    init {

        viewModelScope.launch {
            getTopRatedMovies()
                .onSuccess {
                    _topRatedMovies.value = it
                }
                .onFailure {
                    Log.i("MoviesViewModel", it.message.toString())
                }


            getPopularMovies()
                .onSuccess {
                    _popularMovies.value = it
                }
                .onFailure {
                    Log.i("MoviesViewModel", it.message.toString())
                }
        }
    }
}