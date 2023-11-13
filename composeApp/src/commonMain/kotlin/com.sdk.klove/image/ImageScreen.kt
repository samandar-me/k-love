package com.sdk.klove.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.sdk.klove.component.BackButton
import com.sdk.klove.component.GalleryImage
import com.sdk.klove.component.MyButton
import com.sdk.klove.component.PercentageHeart
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageScreen(
    onBack: () -> Unit
) {
    var s1 by remember { mutableStateOf(false) }
    var s2 by remember { mutableStateOf(false) }
    val vm = viewModel(ImageViewModel::class, keys = listOf()) {
        ImageViewModel()
    }
    val state by vm.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeContent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.Start),
            onBack = onBack
        )
        PercentageHeart(
            value = state.value
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GalleryImage {
                s1 = true
            }
            Image(
                painter = painterResource("heart_arr.png"),
                contentDescription = "",
                modifier = Modifier.size(80.dp).alpha(.7f)
            )
            GalleryImage {
                s2 = true
            }
        }
        Spacer(Modifier.height(50.dp))
        MyButton(
            text = state.text,
            icon = Icons.Default.Favorite,
            enabled = s1 && s2,
            onClick = vm::generate
        )
    }
}