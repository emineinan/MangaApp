package com.example.mangaapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritesEntity(
    @PrimaryKey
    @ColumnInfo(name = "mal_id")
    var malId: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "title_english")
    var title_english: String?,

    @ColumnInfo(name = "title_japanese")
    var title_japanese: String?,

    @ColumnInfo(name = "title_synonyms")
    var title_synonyms: String?,

    @ColumnInfo(name = "url")
    var url: String?,

    @ColumnInfo(name = "images")
    var images: String?,

    @ColumnInfo(name = "type")
    var type: String?,

    @ColumnInfo(name = "chapters")
    var chapters: Int?,

    @ColumnInfo(name = "volumes")
    var volumes: Int?,

    @ColumnInfo(name = "status")
    var status: String?,

    @ColumnInfo(name = "published")
    var published: String?,

    @ColumnInfo(name = "scored")
    var scored: Double?,

    @ColumnInfo(name = "scored_by")
    var scored_by: Int?,

    @ColumnInfo(name = "rank")
    var rank: Int?,

    @ColumnInfo(name = "popularity")
    var popularity: Int?,

    @ColumnInfo(name = "members")
    var members: Int?,

    @ColumnInfo(name = "synopsis")
    var synopsis: String?,

    @ColumnInfo(name = "authors")
    var authors: String?,

    @ColumnInfo(name = "serializations")
    var serializations: String?,

    @ColumnInfo(name = "genres")
    var genres: String?,

    @ColumnInfo(name = "themes")
    var themes: String?,

    @ColumnInfo(name = "demographics")
    var demographics: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)