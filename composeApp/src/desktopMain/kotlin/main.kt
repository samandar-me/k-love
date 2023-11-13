import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.sdk.klove.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Love Calculator"
    ) {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}