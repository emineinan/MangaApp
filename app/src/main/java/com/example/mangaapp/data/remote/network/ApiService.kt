package com.example.mangaapp.data.remote.network

import com.example.mangaapp.data.remote.response.MangaResponses
import retrofit2.http.GET

interface ApiService {
    @GET("top/manga")
    suspend fun getMangas(): MangaResponses?
}