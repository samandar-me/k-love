package com.sdk.klove.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String,
    size: Int
) {
    Text(
        text = text,
        fontSize = size.sp,
        color = Color.White,
        fontStyle = FontStyle.Italic
    )
}