package com.davidcuyas.rickandmortyapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.davidcuyas.rickandmortyapp.framework.navigation.routing.graphs.RootNavGraph

@Composable
fun App() {
    MaterialTheme{
        val navController = rememberNavController()
        RootNavGraph(navController)
    }
}