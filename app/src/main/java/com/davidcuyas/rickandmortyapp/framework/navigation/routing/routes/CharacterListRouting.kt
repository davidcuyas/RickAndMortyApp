package com.davidcuyas.rickandmortyapp.framework.navigation.routing.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.davidcuyas.rickandmortyapp.framework.navigation.ScreenNavigation
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationActions
import com.davidcuyas.rickandmortyapp.presentation.ui.screens.list.CharacterListScreen

fun NavGraphBuilder.characterListRouting(
    navHostController: NavHostController,
    navigationActions: NavigationActions
){
    composable(
        route =  ScreenNavigation.CharacterList.route
    ){
        CharacterListScreen(
            navHostController = navHostController,
            goToCharacterDetail = navigationActions.goToCharacterDetail
        )
    }
}