package com.davidcuyas.rickandmortyapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.BaseViewModel
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto
import com.davidcuyas.rickandmortyapp.usecases.interactors.CharacterInteractors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    application: Application,
    private val interactors: CharacterInteractors
) : BaseViewModel<List<CharacterListDto>>(application) {
    init {
        getAlLDaruma()
    }

    private fun getAlLDaruma() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val darumaList = interactors.getAllCharacters()
                uiState.value = UiState.Success(darumaList)
            } catch (exception: Exception) {
                uiState.value = UiState.Error(exception.message.toString())
            }
        }
    }
}