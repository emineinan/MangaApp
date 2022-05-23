package com.example.mangaapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.data.remote.response.MangaResponses
import com.example.mangaapp.repository.MangaRepository
import com.example.mangaapp.repository.SearchRepository
import com.example.mangaapp.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {
    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    private val _mangas = MutableLiveData<MangaResponses>()
    val mangas: LiveData<MangaResponses> = _mangas

    fun getSearch(
        query: String?
    ): LiveData<MangaResponses> {
        val page = 1
        val limit = 10

        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _mangas.value = searchRepository.getSearch(query, page, limit)
                _status.value = Status.DONE
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _mangas.value?.data = listOf()
            }
        }
        return mangas
    }
}