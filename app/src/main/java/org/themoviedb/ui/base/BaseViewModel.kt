package org.themoviedb.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.themoviedb.framework.utils.ApiCallStatus

abstract class BaseViewModel : ViewModel() {

    protected val apiCallOne = MutableLiveData<ApiCallStatus>()
    val apiCallStatusOne: LiveData<ApiCallStatus>
        get() = apiCallOne

    protected val apiCallTwo = MutableLiveData<ApiCallStatus>()
    val apiCallStatusTwo: LiveData<ApiCallStatus>
        get() = apiCallTwo

}