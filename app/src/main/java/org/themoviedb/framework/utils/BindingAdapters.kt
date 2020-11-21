package org.themoviedb.framework.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide

@Suppress("UNCHECKED_CAST")
@BindingAdapter("app:setList")
fun <T> setList(recyclerView: RecyclerView, data: T?) {
    data?.let {
        if (recyclerView.adapter is GenericAdapter<*>) {
            (recyclerView.adapter as GenericAdapter<T>).setData(data)
        }
    }
}

@BindingAdapter("app:loadImage")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context).load(BASE_IMAGE_URL + url)
            .into(imageView)
    }
}

@BindingAdapter("app:showOnSuccess")
fun showOnSuccess(view: View, apiCallStatus: ApiCallStatus?) {
    apiCallStatus?.let {
        if (apiCallStatus == ApiCallStatus.SUCCESS) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}

@BindingAdapter("app:showOnLoading")
fun showOnLoading(lottie: LottieAnimationView, apiCallStatus: ApiCallStatus?) {
    apiCallStatus?.let {
        if (apiCallStatus == ApiCallStatus.LOADING) {
            lottie.apply {
                visibility = View.VISIBLE
                playAnimation()
            }
        } else {
            lottie.apply {
                visibility = View.GONE
                cancelAnimation()
            }
        }
    }
}

@BindingAdapter("app:showOnError")
fun showOnError(lottie: LottieAnimationView, apiCallStatus: ApiCallStatus?) {
    apiCallStatus?.let {
        if (apiCallStatus == ApiCallStatus.ERROR) {
            lottie.apply {
                visibility = View.VISIBLE
                playAnimation()
            }
        } else {
            lottie.apply {
                visibility = View.GONE
                cancelAnimation()
            }
        }
    }
}

@BindingAdapter("app:emptyStateListSize", "app:emptyStateApiStatus")
fun showEmptyState(view: View, listSize: Int?, apiCallStatus: ApiCallStatus?) {
    if (listSize != null && apiCallStatus != null && apiCallStatus == ApiCallStatus.SUCCESS) {
        view.visibility = if (listSize == 0) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}