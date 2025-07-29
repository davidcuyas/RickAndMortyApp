package com.davidcuyas.rickandmortyapp.presentation.viewmodels.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

open class BaseViewModel<T> @Inject constructor(
    application: Application
) : AndroidViewModel(application) {
    protected open val uiState: MutableStateFlow<UiState<T?>> = MutableStateFlow(UiState.Loading)
    fun uiState(): StateFlow<UiState<T?>> = uiState

    protected val context
        get() = getApplication<Application>()

}