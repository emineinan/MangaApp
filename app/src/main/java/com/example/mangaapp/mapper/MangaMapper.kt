package com.example.mangaapp.mapper

import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.data.remote.response.MangaResponsesData

object DataMapper {
    fun mapResponsesToEntities(input: List<MangaResponsesData>): List<FavoritesEntity> {
        val mangaList = ArrayList<FavoritesEntity>()
        input.map {
            val manga = FavoritesEntity(
                id = it.mal_id,
                name = it.title,
                imageUrl= it.images?.jpg?.largeImageUrl,
                score = it.scored,
                isFavorite = false
            )
            mangaList.add(manga)
        }
        return mangaList
    }

    fun mapEntitiesToDomain(input: List<FavoritesEntity>): List<Manga> =
        input.map {
            Manga(
                malId = it.id,
                title = it.name,
                images = it.imageUrl,
                scored = it.score,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Manga) = FavoritesEntity(
        id = input.malId,
        name = input.title,
        imageUrl = input.images,
        score = input.scored,
        isFavorite = input.isFavorite
    )

    private fun checkNullOrNot(value: String?): String {
        return if (value.isNullOrBlank()) "-" else value
    }

    fun mapSearchToDomain(input: List<MangaResponsesData>): List<Manga> {
        val mangaList = ArrayList<Manga>()
        input.map { it ->
            val manga = Manga(
                malId = it.mal_id,
                title = it.title,
                images = it.images?.jpg?.largeImageUrl,
                scored = it.scored,
                isFavorite = false
            )
            mangaList.add(manga)
        }
        return mangaList
    }
}