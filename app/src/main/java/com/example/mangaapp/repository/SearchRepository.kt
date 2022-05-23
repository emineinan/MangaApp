package com.example.mangaapp.repository

import com.example.mangaapp.data.remote.network.ApiService
import com.example.mangaapp.data.remote.response.MangaResponses
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val mangaService: ApiService
) {
    suspend fun getSearch(
        query: String?,
        page: Int?,
        limit: Int?
    ): MangaResponses? {
        return mangaService.getSearch(query, page, limit)
    }
}