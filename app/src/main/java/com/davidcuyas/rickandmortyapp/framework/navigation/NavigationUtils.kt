package com.davidcuyas.rickandmortyapp.framework.navigation

object NavigationUtils {
    fun parametrizeRoute(
        route: String,
        routeKey: String,
        arg: Any
    ): String {
        return route.replace(
            "{$routeKey}",
            arg.toString()
        )
    }
}