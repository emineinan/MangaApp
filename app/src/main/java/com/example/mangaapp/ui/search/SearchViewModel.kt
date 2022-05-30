package com.example.mangaapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mangaapp.mapper.Manga
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

    private val _mangas = MutableLiveData<List<Manga>>()
    val mangas: LiveData<List<Manga>> = _mangas

    fun search(
        query: String?
    ): LiveData<List<Manga>> {
        val page = 1
        val limit = 10

        viewModelScope.launch {
            _status.value = Status.LOADING
            try {
                _mangas.value = searchRepository.getSearch(query, page, limit)
                _status.value = Status.DONE
            } catch (e: Exception) {
                _status.value = Status.ERROR
                _mangas.value = listOf()
            }
        }
        return mangas
    }
}