package com.davidcuyas.rickandmortyapp.presentation.ui.screens.list

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto

@Composable
fun CharacterListContent(
    context: Context = LocalContext.current,
    uiState: UiState<List<CharacterListDto>?>,
    onClick: (Int) -> Unit = {}
) {
    BaseContentHandler(uiState = uiState) {

    }
}