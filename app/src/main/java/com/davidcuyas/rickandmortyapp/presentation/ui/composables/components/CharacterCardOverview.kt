package com.davidcuyas.rickandmortyapp.presentation.ui.composables.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.davidcuyas.rickandmortyapp.R
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements.InfoText
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.mockCharacterDetail
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PaleLightGoldenrodYellow
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterDetailDto

@Composable
fun CharacterCardOverview(
    modifier: Modifier = Modifier,
    character: CharacterDetailDto?,
    fontFamily: FontFamily = ThemeFontFamily.schoolbellFontFamily
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        color = PaleLightGoldenrodYellow,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = character?.image,
                        placeholder = painterResource(R.drawable.placeholder)
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                InfoText(label = "Name", value = character?.name, fontFamily)
                InfoText(label = "Status", value = character?.status?.capitalize(Locale.current), fontFamily)
                InfoText(label = "Specie", value = character?.species, fontFamily)
            }
        }
    }
}

@Preview
@Composable
private fun CharacterCardOverviewPreview() {
    CharacterCardOverview(
        character = mockCharacterDetail
    )
}