package com.solo4.cheatcodeapp.model

sealed interface ScreenState {
    data object Success : ScreenState
    data object Failure : ScreenState
    data object Loading : ScreenState
    data object None : ScreenState
}
