package com.solo4.cheatcodeapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.solo4.cheatcodeapp.model.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.java.KoinJavaComponent.get

open class AppVM(application: Application = get(Application::class.java)) :
    AndroidViewModel(application) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.None)
    val screenState = _screenState.asStateFlow()
}
