package com.sdk.klove.finger

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import network.KtorfitInstance

class FingerViewModel: ViewModel() {
    private val _state = MutableStateFlow(FingerState())
    val state get() = _state.asStateFlow()
    
    fun generate() {
        viewModelScope.launch {
            val response = KtorfitInstance.getNetworkService().getRandomLove()
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
data class FingerState(
    val value: Int = 0,
    val text: String = "Go"
)