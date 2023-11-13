package com.sdk.klove.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.LocalUIViewController
import androidx.compose.ui.interop.UIKitView
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIImage
import platform.UIKit.UIImageView
import platform.UIKit.UIViewContentMode

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun GalleryImage(modifier: Modifier,onSuccess: () -> Unit) {
    val imagePicker = ImagePicker(LocalUIViewController.current)
    GalleryBox(
        onClick = {
            imagePicker.pickImage()
        }
    ) {
        imagePicker.nsData?.let { data ->
            UIKitView(
                modifier = Modifier.fillMaxSize().clickable {
                    imagePicker.pickImage()
                },
                factory = {
                    onSuccess()
                    UIImageView(UIImage(data)).apply {
                        contentMode = UIViewContentMode.UIViewContentModeScaleAspectFill
                    }
                },
                update = {

                }
            )
        }
    }
}