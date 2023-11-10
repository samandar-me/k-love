package com.sdk.klove.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import java.io.File
import javax.swing.JFileChooser

@Composable
actual fun GalleryImage(modifier: Modifier) {
    var selectedImage by remember { mutableStateOf<File?>(null) }
    val fileChooser = JFileChooser()

    GalleryBox(
        onClick = {
            val result = fileChooser.showOpenDialog(null)
            if(result == JFileChooser.APPROVE_OPTION) {
                selectedImage = fileChooser.selectedFile
            }
        }
    ) {
        selectedImage?.let { file ->
            val imageBitmap = remember(file) {
                loadImageBitmap(file.inputStream())
            }
            Image(
                painter = BitmapPainter(imageBitmap),
                contentDescription = "image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}