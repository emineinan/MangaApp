package com.example.mangaapp.repository

import com.example.mangaapp.data.local.MangaLocalDataSource
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.mapper.DataMapper
import com.example.mangaapp.mapper.Manga
import javax.inject.Inject

class FavoritesRepository @Inject constructor(
    private val mangaLocalDataSource: MangaLocalDataSource
) {
    suspend fun getFavorites(): List<Manga> {
        return DataMapper.mapFavoriteEntitiesToDomain(mangaLocalDataSource.getFavorites())
    }

    suspend fun insertFavoriteManga(manga: Manga) {
        return mangaLocalDataSource.insertFavoriteManga(DataMapper.mapDomainToEntity(manga))
    }

    suspend fun deleteFavoriteManga(manga: Manga) {
        return mangaLocalDataSource.deleteFavoriteManga(DataMapper.mapDomainToEntity(manga))
    }

    suspend fun searchFavoriteManga(malId: Int): FavoritesEntity? {
        return mangaLocalDataSource.searchFavoriteManga(malId)
    }
}