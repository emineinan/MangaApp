package com.example.mangaapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.mapper.Manga
import com.example.mangaapp.repository.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {

    private var _searchedManga = MutableLiveData<FavoritesEntity?>()
    val searchedManga: LiveData<FavoritesEntity?>
        get() = _searchedManga

    fun setFavorite(favoritesEntity: Manga) {
        viewModelScope.launch {
            try {
                favoritesRepository.insertFavoriteManga(favoritesEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteFavorite(favoritesEntity: Manga) {
        viewModelScope.launch {
            try {
                favoritesRepository.deleteFavoriteManga(favoritesEntity)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun searchFavoriteManga(malId: Int) {
        viewModelScope.launch {
            try {
                _searchedManga.value = favoritesRepository.searchFavoriteManga(malId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}