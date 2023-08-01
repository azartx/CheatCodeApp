package com.solo4.cheatcodeapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.solo4.cheatcodeapp.model.ScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class AppVM(application: Application) : AndroidViewModel(application) {
    private val _screenState = MutableStateFlow<ScreenState>(ScreenState.None)
    val screenState = _screenState.asStateFlow()

    inline fun launchMainScope(crossinline action: suspend (CoroutineScope) -> Unit): Job {
        return viewModelScope.launch { action.invoke(this) }
    }

    inline fun launchIoScope(crossinline action: suspend (CoroutineScope) -> Unit): Job {
        return viewModelScope.launch(context = Dispatchers.IO) { action.invoke(this) }
    }
}
