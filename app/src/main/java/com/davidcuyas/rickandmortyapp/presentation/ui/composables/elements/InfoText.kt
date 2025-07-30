package com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily

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

@Preview
@Composable
private fun InfoTextPreview() {
    InfoText(
        label = "Name",
        value = "Rick Sanchez",
        fontFamily = ThemeFontFamily.schoolbellFontFamily
    )
}