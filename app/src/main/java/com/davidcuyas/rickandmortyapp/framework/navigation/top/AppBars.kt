package com.davidcuyas.rickandmortyapp.framework.navigation.top

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.davidcuyas.rickandmortyapp.R

@Composable
fun CharacterListAppBar() {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.screen_title_character_list)) }
    )
}

@Composable
fun CharacterDetailAppBar(
    navHostController: NavHostController? = null
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {navHostController?.popBackStack()}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
            }
        },
        title = { Text(text = stringResource(id = R.string.screen_title_character_detail)) }
    )
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