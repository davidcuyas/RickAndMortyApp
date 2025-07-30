package com.davidcuyas.rickandmortyapp.presentation.ui.composables.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.LemonYellow
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PaleGreen
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PastelRed
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.PowderBlue
import com.davidcuyas.rickandmortyapp.presentation.ui.theme.ThemeFontFamily

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    name: String,
    color: Color,
    fontFamily: FontFamily = ThemeFontFamily.schoolbellFontFamily
) {
    Box(
        modifier = modifier
            .background(color, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = name,
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = fontFamily,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun AliveTagPreview() {
    Tag(
        modifier = Modifier.width(60.dp),
        name = "Alive",
        color = PaleGreen,
    )
}

@Preview
@Composable
private fun DeadTagPreview() {
    Tag(
        modifier = Modifier.width(60.dp),
        name = "Dead",
        color = PastelRed,
    )
}

@Preview
@Composable
private fun UnknownTagPreview() {
    Tag(
        modifier = Modifier.width(80.dp),
        name = "Unknown",
        color = LemonYellow,
    )
}

@Preview
@Composable
private fun HumanTagPreview() {
    Tag(
        modifier = Modifier.width(80.dp),
        name = "Human",
        color = PowderBlue,
    )
}