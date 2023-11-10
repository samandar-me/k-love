package com.sdk.klove

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.TextSnippet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sdk.klove.component.MyButton
import moe.tlaster.precompose.navigation.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen(nav: Navigator) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.9f)
            .windowInsetsPadding(WindowInsets.safeContent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource("lovers.png"),
            contentDescription = "lovers"
        )
        Text(
            text = "Love Calculator",
            fontSize = 40.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
        MyButton(
            text = "Text",
            icon = Icons.Default.TextSnippet,
            onClick = {
                      nav.navigate("/text")
                      },
            )
        MyButton(
            text = "Image",
            icon = Icons.Default.Image,
            onClick = {
                nav.navigate("/image")
                      },
            )
        MyButton(
            text = "Fingerprint",
            icon = Icons.Default.Fingerprint,
            onClick = {
                nav.navigate("/finger")
                      },
            )
    }
}