package com.example.mangaapp.util

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mangaapp.R
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.ui.adapter.MangaAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri){
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<MangaResponsesData>?) {
    val adapter = recyclerView.adapter as MangaAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView, status: MangaApiStatus?) {
    when (status) {
        MangaApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_loading)
        }
        MangaApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MangaApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {}
    }
}