package com.example.mangaapp.repository

import com.example.mangaapp.data.remote.network.ApiService
import com.example.mangaapp.mapper.DataMapper
import com.example.mangaapp.mapper.Manga
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val mangaService: ApiService
) {
    suspend fun getSearch(
        query: String?,
        page: Int?,
        limit: Int?
    ): List<Manga> {
        return DataMapper.mangaResponsesDataListToMangaList(
            mangaService.getSearch(
                query,
                page,
                limit
            )?.data
        )
    }
}