package com.example.mangaapp.data.remote.network

import com.example.mangaapp.data.remote.response.MangaResponses
import com.example.mangaapp.data.remote.response.MangaResponsesData
import com.example.mangaapp.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("top/manga")
    suspend fun getMangas(): MangaResponses?
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

object MangaApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}