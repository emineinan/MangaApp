package com.example.mangaapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MangaResponses(
    @SerializedName("data")
    val `data`: List<MangaResponsesData>
)