package com.example.mangaapp.data.remote.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponsesPublished(
    @Json(name = "string")
    val string: String
) : Parcelable