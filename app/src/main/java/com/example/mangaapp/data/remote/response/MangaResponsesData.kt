package com.example.mangaapp.data.remote.response


import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponsesData(
    @Json(name = "mal_id")
    val mal_id: Int?,
    @Json(name = "authors")
    val authors: List<MangaResponsesAuthor>?,
    @Json(name = "chapters")
    val chapters: Int?,
    @Json(name = "demographics")
    val demographics: List<MangaResponsesDemographic>?,
    @Json(name = "genres")
    val genres: List<MangaResponsesGenre>?,
    @Json(name = "images")
    val images: MangaResponsesImages?,
    @Json(name = "members")
    val members: Int?,
    @Json(name = "popularity")
    val popularity: Int?,
    @Json(name = "published")
    val published: MangaResponsesPublished?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "scored")
    val scored: Double?,
    @Json(name = "scored_by")
    val scoredBy: Int?,
    @Json(name = "serializations")
    val serializations: List<MangaResponsesSerialization>?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "synopsis")
    val synopsis: String?,
    @Json(name = "themes")
    val themes: List<MangaResponsesTheme>?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "title_english")
    val titleEnglish: String?,
    @Json(name = "title_japanese")
    val titleJapanese: String?,
    @Json(name = "title_synonyms")
    val titleSynonyms: List<String>?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "volumes")
    val volumes: Int?
): Parcelable