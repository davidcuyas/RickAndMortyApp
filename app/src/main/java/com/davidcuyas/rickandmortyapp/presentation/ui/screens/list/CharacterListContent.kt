package com.davidcuyas.rickandmortyapp.presentation.ui.screens.list

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.list.CharacterListViewModel
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto

@Composable
fun CharacterListContent(
    context: Context = LocalContext.current,
    uiState: UiState<List<CharacterListDto>?>,
    viewModel: CharacterListViewModel = hiltViewModel(),
    onClick: (Int) -> Unit = {}
) {
    val characters by remember { derivedStateOf { viewModel.characters } }
    val uiState by viewModel.uiState().collectAsState()

    BaseContentHandler(uiState = uiState) {
        LazyColumn {
            itemsIndexed(characters){ index, character ->
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = character.name
                )

                if (index == characters.lastIndex - 5) { //TODO: Constant
                    viewModel.loadCharacters()
                }
            }

            if (uiState is UiState.Loading) {
                item {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}