package com.example.mangaapp.data.local

import com.example.mangaapp.data.local.dao.FavoritesDao
import com.example.mangaapp.data.local.entity.FavoritesEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MangaLocalDataSource @Inject constructor(
    private val favoritesDao: FavoritesDao
) {
    suspend fun getFavorites(): List<FavoritesEntity> {
        return favoritesDao.getFavoriteMangas()
    }

    suspend fun insertFavoriteManga(favoritesEntity: FavoritesEntity) {
        return favoritesDao.insertFavoriteManga(favoritesEntity)
    }

    suspend fun deleteFavoriteManga(favoritesEntity: FavoritesEntity) {
        return favoritesDao.deleteFavoriteManga(favoritesEntity)
    }

    suspend fun deleteAllFavorites(){
        return favoritesDao.deleteAllFavorites()
    }
}