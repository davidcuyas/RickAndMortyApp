package com.davidcuyas.rickandmortyapp.presentation.ui.composables.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.davidcuyas.rickandmortyapp.R
import com.davidcuyas.rickandmortyapp.domain.entities.Status
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily
import com.davidcuyas.rickandmortyapp.usecases.entities.CharacterListDto

@Composable
fun CharacterListItem(
    modifier: Modifier = Modifier,
    character: CharacterListDto,
    onClick: (Int) -> Unit = {}
) {
    val fontFamily = ThemeFontFamily.schoolbellFontFamily
    Column(modifier = modifier
        .clickable {
            onClick(character.id)
        }
        .width(180.dp)
        .padding(8.dp)
        .background(
            color = Color(0xFFF5F9D4),
            shape = RoundedCornerShape(16.dp)
        )
        .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.portal),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
                    .align(Alignment.Center)
            )

            Image(
                painter = rememberAsyncImagePainter(
                    model = character.imageUrl,
                    placeholder = painterResource(R.drawable.placeholder)
                ),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center)
                    .border(1.dp, Color.Black, CircleShape)
            )
        }


        Spacer(modifier = Modifier.height(12.dp))

        Text(
            textAlign = TextAlign.Center,
            text = character.name,
            fontFamily = fontFamily,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB0E0E6), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = character.species,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = fontFamily,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }

            val statusEnum = enumValues<Status>().firstOrNull {
                it.name.equals(character.status, ignoreCase = true)
            }
            val speciesColor = getColorFromStatus(statusEnum)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(speciesColor, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = character.status.capitalize(Locale.current),
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = fontFamily,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun getColorFromStatus(status: Status?): Color{
    return when(status){
        Status.Alive -> Color(0xFF98FB98)
        Status.Dead -> Color(0xFFFF6F69)
        Status.Unknown -> Color(0xFFFFF59D)
        else -> Color(0xFFD3D3D3)
    }
}

@Preview
@Composable
private fun CharacterListItemPreview() {
    CharacterListItem(
        character = CharacterListDto(
            id = 1,
            name = "Rick Sanchez",
            imageUrl = "",
            species = "Human",
            status = "Alive"
        )
    )
}

