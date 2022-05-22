package com.example.mangaapp.data.remote.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponsesJpg(
    @Json(name = "large_image_url")
    val largeImageUrl: String
) : Parcelable