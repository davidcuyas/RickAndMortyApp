package com.davidcuyas.rickandmortyapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.BaseViewModel
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    application: Application,
    private val interactors: CharacterInteractors
) : BaseViewModel<Character>(application) {

    fun getCharacterDetailById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterList = interactors.getCharacterDetailById(id)
                uiState.value = UiState.Success(characterList)
            } catch (exception: Exception) {
                uiState.value = UiState.Error(exception.message.toString())
            }
        }
    }
}