package com.sdk.klove

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.sdk.klove.finger.FingerScreen
import com.sdk.klove.image.ImageScreen
import com.sdk.klove.text.TextScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import network.KtorfitInstance
import network.Person
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    PreComposeApp {
        val navigator = rememberNavigator()
        MaterialTheme {
            NavHost(
                navigator = navigator,
                initialRoute = "/main"
            ) {
                scene("/main") {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource("img.png"),
                            contentDescription = "back",
                            modifier = Modifier.fillMaxSize().blur(10.dp),
                            contentScale = ContentScale.Crop
                        )
                        Surface(modifier = Modifier
                            .fillMaxSize()
                            .windowInsetsPadding(WindowInsets.safeContent),
                                color = Color.Transparent
                        ) {
                            TextScreen()
                        }
                    }
                }
            }
        }
    }
}