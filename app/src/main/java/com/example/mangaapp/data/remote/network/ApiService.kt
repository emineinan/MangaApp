package com.example.mangaapp.data.remote.network

import com.example.mangaapp.data.remote.response.MangaResponses
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top/manga")
    suspend fun getMangas(): MangaResponses?

    @GET("manga")
    suspend fun getSearch(
        @Query("q") query: String?,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?
    ): MangaResponses?
}