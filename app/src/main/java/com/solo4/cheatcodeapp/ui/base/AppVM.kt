package com.solo4.cheatcodeapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.solo4.cheatcodeapp.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class AppVM(application: Application) : AndroidViewModel(application) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.None)
    val screenState = _screenState.asStateFlow()
}
