package com.davidcuyas.rickandmortyapp.presentation.ui.screens.list

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.framework.navigation.top.CharacterListAppBar
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseScaffold
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.character.CharacterListViewModel

@Composable
fun CharacterListScreen(
    navHostController: NavHostController,
    goToCharacterDetail: (Int) -> Unit,
    characterListViewModel: CharacterListViewModel = hiltViewModel()
) {
    BaseScaffold(
        navController = navHostController,
        appBar = { CharacterListAppBar() }
    ) {

        val uiState = characterListViewModel.uiState().collectAsStateWithLifecycle().value
        CharacterListContent(
            uiState = uiState,
            onClick = {
                goToCharacterDetail(it)
            }
        )

    }
}