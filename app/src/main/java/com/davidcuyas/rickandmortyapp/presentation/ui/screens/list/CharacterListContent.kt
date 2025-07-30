package com.davidcuyas.rickandmortyapp.presentation.ui.screens.list

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.components.CharacterListItem
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
        val gridState = rememberLazyGridState()
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = gridState,
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(characters) { index, character ->
                CharacterListItem(
                    character = character,
                    onClick = onClick
                )

                if (index == characters.lastIndex - 5) { // TODO: Constant
                    viewModel.loadCharacters()
                }
            }

            if (uiState is UiState.Loading) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }
/*
        LazyColumn {
            itemsIndexed(characters){ index, character ->
                CharacterListItem(character = character)

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

 */
    }
}