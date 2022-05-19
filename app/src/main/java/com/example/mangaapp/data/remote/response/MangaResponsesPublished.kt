package com.example.mangaapp.data.remote.response

import com.squareup.moshi.Json

data class MangaResponsesPublished(
    @Json(name = "string")
    val string: String
)