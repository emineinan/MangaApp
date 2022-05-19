package com.example.mangaapp.data.remote.response

import com.squareup.moshi.Json

data class MangaResponsesJpg(
    @Json(name = "large_image_url")
    val largeImageUrl: String
)