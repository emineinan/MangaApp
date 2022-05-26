package com.example.mangaapp.mapper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val malId: Int?,
    val title: String?,
    val images: String?,
    val scored: Double?,
    val isFavorite: Boolean? = false
) : Parcelable