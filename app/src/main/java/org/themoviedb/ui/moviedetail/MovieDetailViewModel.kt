package org.themoviedb.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.themobiedb.data.onFailure
import org.themobiedb.data.onSuccess
import org.themobiedb.interactors.GetMovieDetail
import org.themobiedb.model.moviedetail.MovieDetail
import org.themoviedb.framework.utils.ApiCallStatus
import org.themoviedb.ui.base.BaseViewModel

class MovieDetailViewModel(private val getMovieDetail: GetMovieDetail, private val movieId: Int) :
    BaseViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetail>()
    val movieDetail: LiveData<MovieDetail>
        get() = _movieDetail

    init {
        fetchMovieDetail()
    }

    private fun fetchMovieDetail() {
        viewModelScope.launch {
            apiCallOne.value = ApiCallStatus.LOADING

            getMovieDetail(movieId)
                .onSuccess {
                    _movieDetail.value = it
                    apiCallOne.value = ApiCallStatus.SUCCESS
                }
                .onFailure {
                    apiCallOne.value = ApiCallStatus.ERROR
                }
        }
    }
}