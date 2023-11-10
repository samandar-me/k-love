package com.sdk.klove.main

import com.arkivanov.mvikotlin.core.store.Store

interface MainStore: Store<MainStore.Intent, Nothing, Nothing> {
    sealed interface Intent {
        data class OnButtonClicked(val index: Int): Intent
    }
}