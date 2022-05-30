package com.example.mangaapp.mapper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val malId: Int?,
    val title: String?,
    val title_english: String?,
    val title_japanese: String?,
    val title_synonyms: String?,
    val url: String?,
    val images: String?,
    val type: String?,
    val chapters: Int?,
    val volumes: Int?,
    val status: String?,
    val published: String?,
    val scored: Double?,
    val scored_by: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val synopsis: String?,
    val authors: String?,
    val serializations: String?,
    val genres: String?,
    val themes: String?,
    val demographics: String?,
    var isFavorite: Boolean = false
) : Parcelable