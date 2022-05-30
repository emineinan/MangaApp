package com.example.mangaapp.mapper

import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.data.remote.response.MangaResponsesData

object DataMapper {

    fun mangaResponsesDataListToMangaList(mangaList: List<MangaResponsesData>?): List<Manga> {
        val mangas = mutableListOf<Manga>()
        mangaList?.forEach {
            val manga = Manga(
                malId = it.mal_id,
                title = it.title,
                title_english = it.titleEnglish,
                title_japanese = it.titleJapanese,
                title_synonyms = it.titleSynonyms?.joinToString(),
                url = it.url,
                images = it.images?.jpg?.largeImageUrl,
                type = it.type,
                chapters = it.chapters,
                volumes = it.volumes,
                status = it.status,
                published = it.published?.string,
                scored = it.scored,
                scored_by = it.scoredBy,
                rank = it.rank,
                popularity = it.popularity,
                members = it.members,
                synopsis = it.synopsis,
                authors = it.authors?.joinToString { it.name },
                serializations = it.serializations?.joinToString { it.name },
                genres = it.genres?.joinToString { it.name },
                themes = it.themes?.joinToString { it.name },
                demographics = it.demographics?.joinToString { it.name },
                isFavorite = it.isFavorite
            )
            mangas.add(manga)
        }
        return mangas
    }

    fun mapFavoriteEntitiesToDomain(input: List<FavoritesEntity>): List<Manga> {
        val mangas = mutableListOf<Manga>()
        input.forEach {
            val manga=  Manga(
                malId = it.malId,
                title = it.title,
                title_english = it.title_english,
                title_japanese = it.title_japanese,
                title_synonyms = it.title_synonyms,
                url = it.url,
                images = it.images,
                type = it.type,
                chapters = it.chapters,
                volumes = it.volumes,
                status = it.status,
                published = it.published,
                scored = it.scored,
                scored_by = it.scored_by,
                rank = it.rank,
                popularity = it.popularity,
                members = it.members,
                synopsis = it.synopsis,
                authors = it.authors,
                serializations = it.serializations,
                genres = it.genres,
                themes = it.themes,
                demographics = it.demographics,
                isFavorite = it.isFavorite
            )
            mangas.add(manga)
        }
        return mangas
    }

    fun mapResponsesToEntities(input: List<MangaResponsesData>): List<FavoritesEntity> {
        val mangaList = ArrayList<FavoritesEntity>()
        input.map { it ->
            val manga = FavoritesEntity(
                malId = it.mal_id,
                title = it.title,
                title_english = it.titleEnglish,
                title_japanese = it.titleJapanese,
                title_synonyms = it.titleSynonyms.toString(),
                url = it.url,
                images = it.images?.jpg?.largeImageUrl,
                type = it.type,
                chapters = it.chapters,
                volumes = it.volumes,
                status = it.status,
                published = it.published?.string,
                scored = it.scored,
                scored_by = it.scoredBy,
                rank = it.rank,
                popularity = it.popularity,
                members = it.members,
                synopsis = it.synopsis,
                authors = it.authors?.joinToString { it.name },
                serializations = it.serializations?.joinToString { it.name },
                genres = it.genres?.joinToString { it.name },
                themes = it.themes?.joinToString { it.name },
                demographics = it.demographics?.joinToString { it.name },
                isFavorite = it.isFavorite
            )
            mangaList.add(manga)
        }
        return mangaList
    }

    fun mapDomainToEntity(input: Manga) = FavoritesEntity(
        malId = input.malId,
        title = input.title,
        title_english = input.title_english,
        title_japanese = input.title_japanese,
        title_synonyms = input.title_synonyms,
        url = input.url,
        images = input.images,
        type = input.type,
        chapters = input.chapters,
        volumes = input.volumes,
        status = input.status,
        published = input.published,
        scored = input.scored,
        scored_by = input.scored_by,
        rank = input.rank,
        popularity = input.popularity,
        members = input.members,
        synopsis = input.synopsis,
        authors = input.authors,
        serializations = input.serializations,
        genres = input.genres,
        themes = input.themes,
        demographics = input.demographics,
        isFavorite = input.isFavorite
    )

}