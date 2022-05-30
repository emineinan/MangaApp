package com.example.mangaapp.repository

import com.example.mangaapp.data.remote.network.ApiService
import com.example.mangaapp.mapper.DataMapper
import com.example.mangaapp.mapper.Manga
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaListService: ApiService
) {
    suspend fun getMangas(): List<Manga> {
        return DataMapper.mangaResponsesDataListToMangaList(mangaListService.getMangas()?.data)
    }
}