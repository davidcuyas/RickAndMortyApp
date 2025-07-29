package com.davidcuyas.rickandmortyapp.framework.navigation.routing.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.davidcuyas.rickandmortyapp.framework.navigation.ScreenNavigation
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationActions
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.routes.characterDetailRouting
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.routes.characterListRouting

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
    navigationActions: NavigationActions
) {
    navigation(
        startDestination = ScreenNavigation.CharacterList.route,
        route = ScreenNavigation.CharacterList.graph
    ) {
        characterListRouting(
            navHostController = navController,
            navigationActions = navigationActions
        )

        characterDetailRouting(
            navController = navController,
            navigationActions = navigationActions
        )
    }
}