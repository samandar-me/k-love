package com.sdk.klove.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun PercentageHeart(
    value: Int,
    modifier: Modifier = Modifier,
) {
    var number by remember { mutableStateOf(0) }
    var textColor by remember { mutableStateOf(1f) }

    LaunchedEffect(value) {
        number = 0
        textColor = .5f
        repeat(value) {
            number += 1
            delay(number * 4L)
        }
        textColor = 1f
    }

    Box(
        modifier = modifier.fillMaxWidth().heightIn(100.dp, 300.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource("heart.png"),
            contentDescription = "heart",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
        )
        Text(
            text = "$number%",
            fontSize = 50.sp,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(top = 50.dp).alpha(textColor)
        )
    }
    Spacer(Modifier.height(30.dp))
}