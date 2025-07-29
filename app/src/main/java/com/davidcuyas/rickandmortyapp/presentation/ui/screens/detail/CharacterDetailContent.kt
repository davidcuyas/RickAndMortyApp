package com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState

@Composable
fun CharacterDetailContent(
    uiState: UiState<Character?>,
    context: Context = LocalContext.current
) {
    BaseContentHandler(uiState = uiState) {

    }
}