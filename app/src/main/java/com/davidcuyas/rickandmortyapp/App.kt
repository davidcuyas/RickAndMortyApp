package com.davidcuyas.rickandmortyapp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    MaterialTheme{
        val navController = rememberNavController()
    }
}