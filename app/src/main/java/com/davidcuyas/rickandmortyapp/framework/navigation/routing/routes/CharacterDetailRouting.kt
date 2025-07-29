package com.davidcuyas.rickandmortyapp.framework.navigation.routing.routes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.davidcuyas.rickandmortyapp.framework.navigation.ScreenNavigation
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationActions
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationRouteKey
import com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail.CharacterDetailScreen

fun NavGraphBuilder.characterDetailRouting(
    navController: NavHostController,
    navigationActions: NavigationActions
) {
    composable(
        route = ScreenNavigation.CharacterDetail.route,
        arguments = listOf(navArgument(NavigationRouteKey.CHARACTER_DETAIL_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getInt(NavigationRouteKey.CHARACTER_DETAIL_KEY)
        CharacterDetailScreen(
            navHostController = navController,
            navigationActions = navigationActions,
            id = id ?: -1
        )
    }
}