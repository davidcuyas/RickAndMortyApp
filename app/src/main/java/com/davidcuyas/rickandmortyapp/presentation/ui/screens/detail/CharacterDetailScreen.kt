package com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationActions
import com.davidcuyas.rickandmortyapp.framework.navigation.top.CharacterDetailAppBar
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseScaffold
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.character.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(
    navHostController: NavHostController,
    navigationActions: NavigationActions,
    id: Int,
    characterDetailViewModel: CharacterDetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = "CharacterDetailScreen") {
        characterDetailViewModel.getCharacterDetailById(id)
    }

    BaseScaffold(
        navController = navHostController,
        appBar = { CharacterDetailAppBar(navHostController = navHostController) }
    ) {

        val uiState = characterDetailViewModel.uiState().collectAsStateWithLifecycle().value
        CharacterDetailContent(
            uiState = uiState
        )
    }
}