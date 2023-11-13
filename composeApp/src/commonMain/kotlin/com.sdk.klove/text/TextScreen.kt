package com.sdk.klove.text

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdk.klove.component.BackButton
import com.sdk.klove.component.MyButton
import com.sdk.klove.component.PercentageHeart
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class,ExperimentalResourceApi::class)
@Composable
fun TextScreen(
    onBack: () -> Unit
) {
    val vm = viewModel(modelClass = TextViewModel::class, keys = listOf()) {
        TextViewModel()
    }
    val state by vm.state.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeGestures),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.Start),
            onBack = onBack
        )
        PercentageHeart(state.value)
        TextField(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .padding(start = 12.dp)
                .align(Alignment.Start),
            value = state.boyName,
            onValueChange = {
                vm.onEvent(TextEvent.OnBoyNameChanged(it))
            },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
            ),
            placeholder = {
                Text(
                    text = "Boy",
                    color = Color.LightGray,
                    fontSize = 24.sp
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Red.copy(alpha = .6f),
            ),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(Modifier.height(20.dp))
        Image(
            painter = painterResource("heart_arr.png"),
            contentDescription = "",
            modifier = Modifier.size(80.dp).alpha(.7f)
        )
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 12.dp)
        ) {
            Spacer(Modifier.fillMaxWidth(.2f))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.girlName,
                onValueChange = {
                    vm.onEvent(TextEvent.OnGirlNameChanged(it))
                                },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    textAlign = TextAlign.End
                ),
                placeholder = {
                    Text(
                        text = "Girl",
                        color = Color.LightGray,
                        fontSize = 24.sp,
                        textAlign = TextAlign.End
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    cursorColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Red.copy(alpha = .6f),
                    ),
                shape = RoundedCornerShape(12.dp)
            )
        }
        Spacer(Modifier.height(50.dp))
        MyButton(
            text = state.buttonText,
            icon = Icons.Default.Favorite,
            enabled = state.boyName.isNotBlank() && state.girlName.isNotBlank(),
            onClick = {
                vm.onEvent(TextEvent.OnGenerate)
            }
        )
    }
}