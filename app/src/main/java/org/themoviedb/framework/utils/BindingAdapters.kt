package org.themoviedb.framework.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
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