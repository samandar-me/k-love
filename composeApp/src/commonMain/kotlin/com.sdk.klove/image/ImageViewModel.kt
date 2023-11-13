package com.sdk.klove.image

import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import network.KtorfitInstance

class ImageViewModel: ViewModel() {
    private val _state = MutableStateFlow(ImageState())
    val state get() = _state.asStateFlow()

    fun generate() {
        viewModelScope.launch {
            val ktor = KtorfitInstance.getNetworkService()
            val response = ktor.getRandomLove()
            _state.update {
                it.copy(text = "Loading...")
            }
            delay(2000L)
            _state.update {
                it.copy(text = "Go", value = response.value)
            }
        }
    }
}
data class ImageState(
    val value: Int = 0,
    val text: String = "Go"
)
