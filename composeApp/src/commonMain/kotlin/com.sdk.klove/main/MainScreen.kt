package com.sdk.klove.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import com.sdk.klove.component.MyButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource("lovers.png"),
            contentDescription = "lovers"
        )
        Text(
            text = "Love Calculator",
            fontSize = 45.sp,
            color = Color.Red,
            fontStyle = FontStyle.Italic
        )
        MyButton(
            text = "Text",
            icon = Icons.Default.TextSnippet,
            onClick = {},
            )
        MyButton(
            text = "Image",
            icon = Icons.Default.Image,
            onClick = {},
            )
        MyButton(
            text = "Fingerprint",
            icon = Icons.Default.Fingerprint,
            onClick = {},
            )
    }
}