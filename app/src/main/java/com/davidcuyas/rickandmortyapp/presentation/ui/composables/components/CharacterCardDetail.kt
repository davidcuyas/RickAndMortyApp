package com.davidcuyas.rickandmortyapp.presentation.ui.composables.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidcuyas.rickandmortyapp.R
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements.EpisodeInfo
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements.InfoText
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.mockCharacterDetail
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.Water
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto

@Composable
fun CharacterCardDetail(
    modifier: Modifier = Modifier,
    character: CharacterDetailDto?,
    fontFamily: FontFamily = ThemeFontFamily.schoolbellFontFamily
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        shape = RoundedCornerShape(16.dp),
        color = Water,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            InfoText(
                label = stringResource(R.string.character_card_detail_type),
                value = character?.type,
                fontFamily = fontFamily
            )
            InfoText(
                label = stringResource(R.string.character_card_detail_origin),
                value = character?.origin?.name,
                fontFamily = fontFamily
            )
            InfoText(
                label = stringResource(R.string.character_card_detail_location),
                value = character?.location?.name,
                fontFamily = fontFamily
            )

            val episodeCount = character?.episode?.count() ?: 0
            val appearsOnEpisodesText = LocalContext.current.resources.getQuantityString(
                R.plurals.character_card_detail_episodes_appearance,
                episodeCount
            )

            Text(appearsOnEpisodesText, fontFamily = fontFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                LazyColumn {
                    items(episodeCount){
                        val episode = character?.episode?.get(it)
                        EpisodeInfo(episode = episode, fontFamily = fontFamily)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CharacterCardDetailPreview() {
    CharacterCardDetail(
        character = mockCharacterDetail
    )
}