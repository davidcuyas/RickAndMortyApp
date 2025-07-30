package com.davidcuyas.rickandmortyapp.framework.navigation.top

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.R

@Composable
fun CharacterListAppBar() {
    Box(modifier = Modifier.fillMaxWidth().height(80.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.rick_and_morty_title),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(8.dp),
        )

        TopAppBar(
            title = {
            },
            modifier = Modifier.height(80.dp),
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        )
    }
}

@Composable
fun CharacterDetailAppBar(
    navHostController: NavHostController? = null
) {
    Box(modifier = Modifier.fillMaxWidth().height(80.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.rick_and_morty_title),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(8.dp),
        )

        TopAppBar(
            navigationIcon = {
                IconButton(onClick = {navHostController?.popBackStack()}) {
                    Icon(
                        modifier = Modifier.padding(start = 8.dp),
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = "",
                        tint = Color.Black)
                }
            },
            title = {
            },
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        )
    }
}

@Preview
@Composable
private fun CharacterListAppBarPreview() {
    CharacterListAppBar()
}

@Preview
@Composable
private fun CharacterDetailAppBarPreview() {
    CharacterDetailAppBar()
}