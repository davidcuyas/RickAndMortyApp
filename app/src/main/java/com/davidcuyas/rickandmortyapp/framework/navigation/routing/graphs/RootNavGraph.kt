package com.davidcuyas.rickandmortyapp.framework.navigation.routing.graphs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.davidcuyas.rickandmortyapp.framework.navigation.ScreenNavigation
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.NavigationActions

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    val navigationActions = remember(navController){
        NavigationActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = ScreenNavigation.CharacterList.graph
    ){
        homeNavGraph(
            navController = navController,
            navigationActions = navigationActions
        )
    }
}