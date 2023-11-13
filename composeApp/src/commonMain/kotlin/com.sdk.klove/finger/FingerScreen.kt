package com.sdk.klove.finger

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.sdk.klove.component.BackButton
import com.sdk.klove.component.FingerButton
import com.sdk.klove.component.MyButton
import com.sdk.klove.component.PercentageHeart
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun FingerScreen(
    onBack: () -> Unit
) {
    var s1 by remember { mutableStateOf(false) }
    var s2 by remember { mutableStateOf(false) }
    val vm = viewModel(FingerViewModel::class, keys = listOf()) {
        FingerViewModel()
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            FingerButton {
                s1 = true
            }
            Image(
                painter = painterResource("heart_arr.png"),
                contentDescription = "heart",
                modifier = Modifier.size(40.dp)
            )
            FingerButton {
                s2 = true
            }
        }
        Spacer(Modifier.height(50.dp))
        MyButton(
            text = state.text,
            icon = Icons.Default.Favorite,
            enabled = s1 && s2,
            onClick = {
                vm.generate()
            }
        )
    }
}