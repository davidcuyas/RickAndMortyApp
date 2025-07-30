package com.davidcuyas.rickandmortyapp.presentation.ui.screens.detail

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.davidcuyas.rickandmortyapp.R
import com.davidcuyas.rickandmortyapp.domain.entities.Character
import com.davidcuyas.rickandmortyapp.presentation.ui.shared.BaseContentHandler
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily
import com.davidcuyas.rickandmortyapp.presentation.viewmodels.base.UiState

@Composable
fun CharacterDetailContent(
    uiState: UiState<Character?>,
    onBack: () -> Unit = {},
    onNext: () -> Unit = {},
    context: Context = LocalContext.current
) {
    val fontFamily = ThemeFontFamily.playFontFamily
    BaseContentHandler(uiState = uiState) {
        val character = (uiState as UiState.Success).data

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFF7F6CB),
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

            // Bottom card - other info
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFCCEFFF), // light blue
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    InfoText(label = "Type", value = character?.type, fontFamily)
                    InfoText(label = "Origin", value = character?.origin?.name, fontFamily)
                    InfoText(label = "Location", value = character?.location?.name, fontFamily)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Appears on these episodes:", fontFamily = fontFamily, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        LazyColumn {
                            items(character?.episode?.count() ?: 0){
                                Text(text = character?.episode?.get(it) ?: "", fontFamily = fontFamily)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun InfoText(label: String, value: String?, fontFamily: FontFamily) {
    if (!value.isNullOrBlank()) {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        fontFamily = fontFamily
                    )
                ) {
                    append("$label: ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        fontFamily = fontFamily
                    )
                ) {
                    append(value)
                }
            }
        )
    }
}

/*
@Composable
fun InfoText(label: String, value: String?, fontFamily: FontFamily) {
    if(!value.isNullOrBlank()){
        Text(
            text = "$label : $value",
            fontSize = 16.sp,
            fontFamily = fontFamily
        )
    }
}

 */