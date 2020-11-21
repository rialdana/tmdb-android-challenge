package org.themoviedb.ui.searchmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.themobiedb.data.onFailure
import org.themobiedb.data.onSuccess
import org.themobiedb.interactors.SearchMovies
import org.themobiedb.model.movies.Movies
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.base.BaseViewModel

class SearchMovieViewModel(private val searchMovies: SearchMovies, val query: String) :
    BaseViewModel() {

    private val _movies = MutableLiveData<Movies>()
    val movies: LiveData<Movies>
        get() = _movies

    init {
        getMovieResults()
    }

    private fun getMovieResults() {
        viewModelScope.launch {
            apiCallOne.value = ApiCallStatus.LOADING

            searchMovies(query)
                .onSuccess {
                    _movies.value = it
                    apiCallOne.value = ApiCallStatus.SUCCESS
                }
                .onFailure {
                    apiCallOne.value = ApiCallStatus.ERROR
                }
        }
    }

}