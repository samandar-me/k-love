package com.sdk.klove.text

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sdk.klove.component.MyButton
import com.sdk.klove.component.PercentageHeart
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class,ExperimentalResourceApi::class)
@Composable
fun TextScreen() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))
        PercentageHeart(0)
        TextField(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .padding(start = 12.dp)
                .align(Alignment.Start),
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            ),
            placeholder = {
                Text(
                    text = "Boy",
                    color = Color.LightGray,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic
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
                value = text,
                onValueChange = {
                    text = it
                },
                textStyle = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End
                ),
                placeholder = {
                    Text(
                        text = "Girl",
                        color = Color.LightGray,
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic,
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
            text = "Go",
            icon = Icons.Default.Favorite,
            enabled = text.isNotBlank(),
            onClick = {

            }
        )
    }
}