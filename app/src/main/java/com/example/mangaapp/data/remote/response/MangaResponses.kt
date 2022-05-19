package com.example.mangaapp.data.remote.response

import com.squareup.moshi.Json

data class MangaResponses(
    @Json(name = "data")
    var `data`: List<MangaResponsesData>
)