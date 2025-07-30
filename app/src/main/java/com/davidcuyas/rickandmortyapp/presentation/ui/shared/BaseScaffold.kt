package com.davidcuyas.rickandmortyapp.presentation.ui.shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.R

@Composable
fun BaseScaffold(
    appBar: @Composable () -> Unit = {},
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val background = if(isSystemInDarkTheme()){
            R.drawable.dark_background
        }else{
            R.drawable.light_background
        }

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Scaffold(
            modifier = Modifier.padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
            ),
            topBar = { appBar() },
            bottomBar = {
            },
            backgroundColor = Color.Transparent,
            contentColor = Color.Transparent
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding()
                )
            ) {
                content(it)
            }
        }
    }
}