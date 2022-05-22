package com.example.mangaapp.di

import android.content.Context
import androidx.room.Room
import com.example.mangaapp.data.local.dao.FavoritesDao
import com.example.mangaapp.data.local.database.FavoritesDatabase
import com.example.mangaapp.data.local.database.FavoritesDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FavoritesDatabase = Room.databaseBuilder(context, FavoritesDatabase::class.java, DB_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(database: FavoritesDatabase): FavoritesDao = database.favoritesDao()
}