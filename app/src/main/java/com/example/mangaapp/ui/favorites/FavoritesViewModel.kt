package com.example.mangaapp.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.data.local.entity.FavoritesEntity
import com.example.mangaapp.repository.FavoritesRepository
import com.example.mangaapp.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModel() {
    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    private val _favoriteMangas = MutableLiveData<List<FavoritesEntity>>()
    val favoriteMangas: LiveData<List<FavoritesEntity>> = _favoriteMangas

    init {
        getMangas()
    }

    fun getMangas() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _favoriteMangas.value = favoritesRepository.getFavorites()
                _status.value = Status.DONE
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _favoriteMangas.value = listOf()
            }
        }
    }

    fun deleteAllFavorites() {
        CoroutineScope(Dispatchers.IO).launch {
            favoritesRepository.deleteAllFavorites()
        }
    }
}