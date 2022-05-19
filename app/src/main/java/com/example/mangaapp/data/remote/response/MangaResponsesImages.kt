package com.example.mangaapp.data.remote.response

import com.squareup.moshi.Json

data class MangaResponsesImages(
    @Json(name = "jpg")
    val jpg: MangaResponsesJpg
)