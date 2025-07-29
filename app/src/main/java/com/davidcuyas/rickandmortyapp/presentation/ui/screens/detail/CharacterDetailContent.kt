package com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState

@Composable
fun CharacterDetailContent(
    uiState: UiState<Character?>,
    context: Context = LocalContext.current
) {
    BaseContentHandler(uiState = uiState) {
        val character = (uiState as UiState.Success).data

        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "${character?.id} - ${character?.name}"
        )
    }
}