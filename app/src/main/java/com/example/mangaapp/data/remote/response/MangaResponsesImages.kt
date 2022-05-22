package com.example.mangaapp.data.remote.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponsesImages(
    @Json(name = "jpg")
    val jpg: MangaResponsesJpg
) : Parcelable