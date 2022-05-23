package com.example.mangaapp.util

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mangaapp.R
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.ui.adapter.FavoritesAdapter
import com.example.mangaapp.ui.adapter.MangaAdapter

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri) {
            placeholder(R.drawable.ic_loading)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listHomeData")
fun bindHomeRecyclerView(
    recyclerView: RecyclerView,
    data: List<MangaResponsesData>?
) {
    val adapter = recyclerView.adapter as MangaAdapter?
    adapter?.submitList(data)
}

@BindingAdapter("listFavoriteData")
fun bindFavoriteRecyclerView(
    recyclerView: RecyclerView,
    data: List<FavoritesEntity>?
) {
    val adapter = recyclerView.adapter as FavoritesAdapter?
    adapter?.submitList(data)
}

@BindingAdapter("mangaApiStatus")
fun bindStatus(statusImageView: ImageView, status: Status?) {
    when (status) {
        Status.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_loading)
        }
        Status.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        Status.DONE -> {
            statusImageView.visibility = View.GONE
        }
        else -> {
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("dataCheck")
fun dataCheck(textView: TextView, data: List<FavoritesEntity>?) {
    if (data != null) {
        if (data.isEmpty()) {
            textView.text = "No favorite manga added."
        } else {
            textView.text = ""
        }
    }
}