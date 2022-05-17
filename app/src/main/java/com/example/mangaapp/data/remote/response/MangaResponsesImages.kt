package com.example.mangaapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MangaResponsesImages(
    @SerializedName("jpg")
    val jpg: MangaResponsesJpg
)