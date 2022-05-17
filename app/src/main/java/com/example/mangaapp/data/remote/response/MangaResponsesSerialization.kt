package com.example.mangaapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MangaResponsesSerialization(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)