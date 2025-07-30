package com.davidcuyas.rickandmortyapp.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.davidcuyas.rickandmortyapp.R

@Composable
fun rememberGoogleFontFamily(fontName: String = "Lato"): FontFamily {
    val context = LocalContext.current
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs // built-in certs
    )

    val googleFont = GoogleFont(fontName)

    return remember(fontName) {
        FontFamily(
            Font(
                googleFont = googleFont,
                fontProvider = provider,
                weight = FontWeight.Normal
            )
        )
    }
}