package com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.davidcuyas.rickandmortyapp.domain.entities.Episode
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.mockEpisodeList
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily

@Composable
fun EpisodeInfo(
    modifier: Modifier = Modifier,
    episode: Episode?,
    fontFamily: FontFamily = ThemeFontFamily.schoolbellFontFamily
) {
    Text(text = "${episode?.episode} - ${episode?.name}", fontFamily = fontFamily)
}

@Preview
@Composable
private fun EpisodeInfoPreview() {
    EpisodeInfo(
        episode = mockEpisodeList.first()
    )
}