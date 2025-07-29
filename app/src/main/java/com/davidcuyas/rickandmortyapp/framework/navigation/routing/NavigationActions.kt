package com.davidcuyas.rickandmortyapp.framework.navigation.routing

import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.framework.navigation.NavigationUtils
import com.davidcuyas.rickandmortyapp.framework.navigation.ScreenNavigation

class NavigationActions(navController: NavHostController) {
    val goToCharacterDetail: (Int?) -> Unit = { id ->
        val characterId = id ?: -1
        val navigationRouteWithArgument =
            NavigationUtils.parametrizeRoute(
                route = ScreenNavigation.CharacterDetail.route,
                routeKey = NavigationRouteKey.CHARACTER_DETAIL_KEY,
                arg = characterId
            )

        navController.navigate(navigationRouteWithArgument)
    }
}