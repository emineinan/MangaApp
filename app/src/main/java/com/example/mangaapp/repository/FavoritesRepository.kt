package com.example.mangaapp.repository

import com.example.mangaapp.data.local.database.FavoritesDatabase
import com.example.mangaapp.data.local.entity.FavoritesEntity
import javax.inject.Inject

class FavoritesRepository @Inject constructor(
    private val favoritesDatabase: FavoritesDatabase
) {
    suspend fun getFavorites(): List<FavoritesEntity> {
        return favoritesDatabase.favoritesDao().getFavoriteMangas()
    }

    suspend fun getMangaById(id: String): FavoritesEntity? {
        return favoritesDatabase.favoritesDao().getMangaById(id)
    }

    suspend fun insertFavoriteManga(favoritesEntity: FavoritesEntity) {
        return favoritesDatabase.favoritesDao().insertFavoriteManga(favoritesEntity)
    }

    suspend fun deleteFavoriteManga(favoritesEntity: FavoritesEntity) {
        return favoritesDatabase.favoritesDao().deleteFavoriteManga(favoritesEntity)
    }
}