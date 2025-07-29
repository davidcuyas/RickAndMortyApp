package com.davidcuyas.rickandmortyapp.presentation.viewmodels.list

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.viewModelScope
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.BaseViewModel
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    application: Application,
    private val interactors: CharacterInteractors
) : BaseViewModel<List<CharacterListDto>>(application) {
    private var currentPage = 1
    private var isLoadingMore = false

    private val _characters = mutableStateListOf<CharacterListDto>()
    val characters: List<CharacterListDto> get() = _characters

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        if (isLoadingMore) return
        isLoadingMore = true
        viewModelScope.launch {
            try {
                if (_characters.isEmpty()) uiState.value = UiState.Loading

                val newCharacters = interactors.getAllCharacters(currentPage)
                val existingIds = _characters.map { it.id }.toSet()
                val uniqueNewCharacters = newCharacters.filterNot { it.id in existingIds }

                _characters.addAll(uniqueNewCharacters)
                uiState.value = UiState.Success(_characters.toList())
                currentPage++
            } catch (e: Exception) {
                uiState.value = UiState.Error(e.message ?: "Unknown error")
            } finally {
                isLoadingMore = false
            }
        }
    }
}