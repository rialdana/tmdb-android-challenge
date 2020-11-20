package org.themoviedb.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.themobiedb.data.onFailure
import org.themobiedb.data.onSuccess
import org.themobiedb.interactors.GetPopularMovies
import org.themobiedb.interactors.GetTopRatedMovies
import org.themobiedb.model.movies.Movies
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.base.BaseViewModel

class MoviesViewModel(
    private val getTopRatedMovies: GetTopRatedMovies,
    private val getPopularMovies: GetPopularMovies
) : BaseViewModel() {

    private val _topRatedMovies = MutableLiveData<Movies>()
    val topRatedMovies: LiveData<Movies>
        get() = _topRatedMovies

    private val _popularMovies = MutableLiveData<Movies>()
    val popularMovies: LiveData<Movies>
        get() = _popularMovies

    init {
        loadTopRatedMovies()
        loadPopularMovies()
    }

    private fun loadTopRatedMovies() {
        viewModelScope.launch {
            apiCallOne.value = ApiCallStatus.LOADING

            getTopRatedMovies()
                .onSuccess {
                    _topRatedMovies.value = it
                    apiCallOne.value = ApiCallStatus.SUCCESS
                }
                .onFailure {
                    apiCallOne.value = ApiCallStatus.ERROR
                }
        }
    }

    private fun loadPopularMovies() {
        viewModelScope.launch {
            apiCallTwo.value = ApiCallStatus.LOADING

            getPopularMovies()
                .onSuccess {
                    _popularMovies.value = it
                    apiCallTwo.value = ApiCallStatus.SUCCESS
                }
                .onFailure {
                    apiCallTwo.value = ApiCallStatus.ERROR
                }
        }
    }
}