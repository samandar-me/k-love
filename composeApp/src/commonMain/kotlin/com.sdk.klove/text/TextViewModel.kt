package com.sdk.klove.text

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import network.KtorfitInstance

class TextViewModel : ViewModel() {
    private val _state = MutableStateFlow(TextState())
    val state get() = _state.asStateFlow()
    
    fun onEvent(event: TextEvent) {
        when(event) {
            is TextEvent.OnBoyNameChanged -> {
                _state.update {
                    it.copy(boyName = event.name)
                }
            }
            is TextEvent.OnGirlNameChanged -> {
                _state.update {
                    it.copy(girlName = event.name)
                }
            }
            is TextEvent.OnGenerate -> {
                viewModelScope.launch {
                    val service = KtorfitInstance.getNetworkService()
                    val response = service.getRandomLove(
                    )
                    _state.update {
                        it.copy(buttonText = "Loading...")
                    }
                    delay(2000L)
                    _state.update {
                        it.copy(
                            buttonText = "Go",
                            value = response.value
                        )
                    }
                }
            }
        }
    }
}
sealed interface TextEvent {
    data class OnBoyNameChanged(val name: String): TextEvent
    data class OnGirlNameChanged(val name: String): TextEvent
    data object OnGenerate: TextEvent
}
data class TextState(
    val boyName: String = "",
    val girlName: String = "",
    val value: Int = 0,
    val buttonText: String = "Go"
)