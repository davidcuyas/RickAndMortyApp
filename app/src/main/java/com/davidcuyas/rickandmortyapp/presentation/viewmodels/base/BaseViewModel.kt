package com.davidcuyas.rickandmortyapp.presentation.viewmodels.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

open class BaseViewModel<T> () : ViewModel() {
    protected open val uiState: MutableStateFlow<UiState<List<T>>> = MutableStateFlow(UiState.Loading)
    fun uiState(): StateFlow<UiState<List<T>>> = uiState

    //TODO: Define context
}