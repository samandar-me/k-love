package com.sdk.klove.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FingerButton(
    onSuccess: () -> Unit
) {
    var isLongClicked by remember { mutableStateOf(false) }
    var isScanning by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val color by animateColorAsState(
        targetValue = if (isLongClicked) Color.Green else Color.Black,
        animationSpec = tween(2000,0, LinearEasing)
    )
    val animatedProgress = rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = if (isScanning) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Surface(
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(
                onLongPress = {
                    scope.launch {
                        isLongClicked = true
                        isScanning = true
                        delay(3000L)
                        isScanning = false
                        onSuccess()
                    }
                }
            )
        }.drawBehind {
            val lineY = size.height * animatedProgress.value
            drawLine(
                color = Color.Red,
                start = Offset(0f, lineY),
                end = Offset(size.width, lineY),
                strokeWidth = 5f
            )
        },
        color = Color.Transparent
    ) {
        Icon(
            painter = painterResource("finger.png"),
            contentDescription = "finger",
            modifier = Modifier.size(140.dp),
            tint = color
        )
    }
}
