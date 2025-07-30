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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.davidcuyas.rickandmortyapp.R
import com.davidcuyas.rickandmortyapp.domain.entities.Status
import com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements.Tag
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.LemonYellow
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.LightGoldenrodYellow
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.LightGray
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PaleGreen
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PastelRed
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PowderBlue
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
            color = LightGoldenrodYellow,
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
            Tag(
                modifier = Modifier.weight(1f),
                name = character.species,
                color = PowderBlue,
                fontFamily = fontFamily
            )

            val speciesColor = getColorFromStatus(getStatusEnumFromName(character.status))

            Tag(
                modifier = Modifier.weight(1f),
                name = character.status.capitalize(Locale.current),
                color = speciesColor,
                fontFamily = fontFamily
            )
        }
    }
}

private fun getStatusEnumFromName(status: String): Status?{
    return enumValues<Status>().firstOrNull {
        it.name.equals(status, ignoreCase = true)
    }
}

private fun getColorFromStatus(status: Status?): Color{
    return when(status){
        Status.Alive -> PaleGreen
        Status.Dead -> PastelRed
        Status.Unknown -> LemonYellow
        else -> LightGray
    }
}

@Preview
@Composable
private fun HumanAliveCharacterListItemPreview() {
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

@Preview
@Composable
private fun AlienDeadCharacterListItemPreview() {
    CharacterListItem(
        character = CharacterListDto(
            id = 1,
            name = "Rick Sanchez",
            imageUrl = "",
            species = "Alien",
            status = "Dead"
        )
    )
}

@Preview
@Composable
private fun AnimalUnknownCharacterListItemPreview() {
    CharacterListItem(
        character = CharacterListDto(
            id = 1,
            name = "Rick Sanchez",
            imageUrl = "",
            species = "Animal",
            status = "Unknown"
        )
    )
}



