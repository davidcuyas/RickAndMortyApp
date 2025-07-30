package com.davidcuyas.rickandmortyapp.presentation.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.davidcuyas.rickandmortyapp.R

object ThemeFontFamily {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    private val schoolbellFontName = GoogleFont("Schoolbell")
    val schoolbellFontFamily = FontFamily(
        Font(googleFont = schoolbellFontName, fontProvider = provider, weight = FontWeight.Normal)
    )

    private val playFontName = GoogleFont("Play")
    val playFontFamily = FontFamily(
        Font(googleFont = playFontName, fontProvider = provider, weight = FontWeight.Normal)
    )
}