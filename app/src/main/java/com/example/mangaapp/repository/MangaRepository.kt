package com.example.mangaapp.repository

import com.example.mangaapp.data.remote.network.ApiService
import com.example.mangaapp.data.remote.response.MangaResponses
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaListService: ApiService
) {
    suspend fun getMangas(): MangaResponses? {
        return mangaListService.getMangas()
    }
}