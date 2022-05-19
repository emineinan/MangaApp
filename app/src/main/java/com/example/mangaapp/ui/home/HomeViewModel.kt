package com.example.mangaapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.data.remote.response.MangaResponses
import com.example.mangaapp.repository.MangaRepository
import com.example.mangaapp.util.MangaApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mangaListRepository: MangaRepository
): ViewModel() {
    private val _status = MutableLiveData<MangaApiStatus>()
    val status: LiveData<MangaApiStatus> = _status

    private val _mangas = MutableLiveData<MangaResponses>()
    val mangas: LiveData<MangaResponses> = _mangas

    init {
        getMangas()
    }

    private fun getMangas() {
        viewModelScope.launch {
            _status.value = MangaApiStatus.LOADING
            try {
                _mangas.value = mangaListRepository.getMangas()
                _status.value = MangaApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MangaApiStatus.ERROR
                Log.e("HATAA",e.message.toString())
                _mangas.value?.data= listOf()
            }
        }
    }
}