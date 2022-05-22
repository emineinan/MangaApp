package com.example.mangaapp.data.remote.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponsesAuthor(
    @Json(name = "mal_id")
    val malId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
): Parcelable