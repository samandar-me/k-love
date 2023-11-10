package com.sdk.klove.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GalleryBox(
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier.size(height = 170.dp, width = 120.dp).border(
            2.dp, Color.Red, RoundedCornerShape(12.dp)
        ).clip(RoundedCornerShape(12.dp))
            .clickable {
               onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(Icons.Default.Image, "image", modifier = Modifier.size(50.dp),tint = Color.Black)
        content(this)
    }
}