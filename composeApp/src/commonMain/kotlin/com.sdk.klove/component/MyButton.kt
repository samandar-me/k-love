package com.sdk.klove.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
            .height(68.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                1.dp,
                Color.Blue,
                RoundedCornerShape(12.dp)
            )
            .background(
                Brush.linearGradient(
                    if (enabled)
                        listOf(
                            Color.Magenta,
                            Color.Red.copy(alpha = .8f),
                            Color.Blue.copy(alpha = .6f)
                        ) else
                        listOf(Color.LightGray,Color.LightGray.copy(.9f))
                )
            )
            .clickable(enabled = enabled, role = Role.Button) {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = FontFamily.Monospace
            )
            if (icon != null) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = icon,
                    contentDescription = "image",
                    tint = Color.White
                )
            }
        }
    }
}