package com.example.mangaapp.data.remote.response

import com.squareup.moshi.Json

data class MangaResponsesTheme(
    @Json(name = "mal_id")
    val malId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String
)