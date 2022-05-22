package com.example.mangaapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritesEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val imageUrl: String,
    val score: Double
)