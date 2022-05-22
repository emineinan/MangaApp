package com.example.mangaapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.repository.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    fun setFavorite(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            try {
                favoritesRepository.insertFavoriteManga(favoritesEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}