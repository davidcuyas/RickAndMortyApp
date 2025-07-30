package com.davidcuyas.rickandmortyapp.presentation.ui.screens.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davidcuyas.rickandmortyapp.framework.api.PaginationThreshold
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.components.CharacterListItem
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.mockCharacterList
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto

@Composable
fun CharacterListContent(
    modifier: Modifier = Modifier,
    uiState: UiState<List<CharacterListDto>?>,
    onClick: (Int) -> Unit = {},
    onLoadMore: () -> Unit = {}
) {
    BaseContentHandler(uiState = uiState) {
        val characters = if(uiState is UiState.Success){
            uiState.data ?: listOf()
        }else{
            listOf()
        }

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

                if (index == characters.lastIndex - PaginationThreshold) {
                    onLoadMore()
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
    }
}

@Preview
@Composable
private fun CharacterListContentPreview() {
    CharacterListContent(
        uiState = UiState.Success(mockCharacterList)
    )
}