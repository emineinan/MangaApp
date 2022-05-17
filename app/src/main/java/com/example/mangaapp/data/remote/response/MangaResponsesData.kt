package com.example.mangaapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class MangaResponsesData(
    @SerializedName("mal_id")
    val mal_id: Int,
    @SerializedName("authors")
    val authors: List<MangaResponsesAuthor>,
    @SerializedName("chapters")
    val chapters: Int,
    @SerializedName("demographics")
    val demographics: List<MangaResponsesDemographic>,
    @SerializedName("genres")
    val genres: List<MangaResponsesGenre>,
    @SerializedName("images")
    val images: MangaResponsesImages,
    @SerializedName("members")
    val members: Int,
    @SerializedName("popularity")
    val popularity: Int,
    @SerializedName("published")
    val published: MangaResponsesPublished,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("scored")
    val scored: Double,
    @SerializedName("scored_by")
    val scoredBy: Int,
    @SerializedName("serializations")
    val serializations: List<MangaResponsesSerialization>,
    @SerializedName("status")
    val status: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("themes")
    val themes: List<MangaResponsesTheme>,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_japanese")
    val titleJapanese: String,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("volumes")
    val volumes: Int
)