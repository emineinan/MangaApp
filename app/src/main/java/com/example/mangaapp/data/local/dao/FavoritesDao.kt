package com.example.mangaapp.data.local.dao

import androidx.room.*
import com.example.mangaapp.data.local.entity.FavoritesEntity

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteManga(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    suspend fun getFavoriteMangas(): List<FavoritesEntity>

    @Delete
    suspend fun deleteFavoriteManga(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM FavoritesEntity")
    fun deleteAllFavorites()
}