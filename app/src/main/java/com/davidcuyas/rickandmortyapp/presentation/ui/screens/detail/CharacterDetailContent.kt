package com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.components.CharacterCardDetail
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.components.CharacterCardOverview
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.mockCharacterDetail
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto

@Composable
fun CharacterDetailContent(
    uiState: UiState<CharacterDetailDto?>
) {
    val fontFamily = ThemeFontFamily.playFontFamily
    BaseContentHandler(uiState = uiState) {
        val character = (uiState as UiState.Success).data

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CharacterCardOverview(
                character = character,
                fontFamily = fontFamily
            )

            CharacterCardDetail(
                character = character,
                fontFamily = fontFamily
            )
        }
    }
}

@Preview
@Composable
private fun CharacterDetailContentPreview() {
    CharacterDetailContent(
        uiState = UiState.Success(mockCharacterDetail)
    )
}