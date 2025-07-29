package com.davidcuyas.rickandmortyapp.presentation.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState

@Composable
fun BaseContentHandler(
    uiState: UiState<*>,
    content: @Composable () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp).align(Alignment.CenterVertically)
                )
            }

            is UiState.Error -> {
                Text(
                    text = "Error: ${uiState.message}",
                    color = Color.Red
                )
            }

            is UiState.Success -> {
                content()
            }
        }
    }

}