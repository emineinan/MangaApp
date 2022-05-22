package com.example.mangaapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mangaapp.data.local.dao.FavoritesDao
import com.example.mangaapp.data.local.database.FavoritesDatabase.Companion.DB_VERSION
import com.example.mangaapp.data.local.entity.FavoritesEntity

@Database(
    entities = [FavoritesEntity::class],
    version = DB_VERSION, exportSchema = true
)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao

    companion object {
        const val DB_NAME = "favorites_database"
        const val DB_VERSION = 1
    }
}