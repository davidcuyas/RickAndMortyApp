package com.davidcuyas.rickandmortyapp.framework.navigation

import com.davidcuyas.rickandmortyapp.framework.navigation.top.AppBarType

sealed class ScreenNavigation(
    val route: String,
    val title: String,
    val appBarType: AppBarType? = null,
    val graph: String = ""
) {
    data object CharacterList : ScreenNavigation(
        route = "characterList",
        title = "Character list",
        graph = "character-list-graph",
        appBarType = AppBarType.LIST
    )
    data object CharacterDetail : ScreenNavigation(
        route = "characterDetail",
        title = "Character detail",
        graph = "character-detail-graph",
        appBarType = AppBarType.DETAIL
    )
}