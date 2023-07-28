package com.solo4.cheatcodeapp.ui.screens

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solo4.cheatcodeapp.ui.base.AppVM
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AppVM(application) {
    class Factory @Inject constructor(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(application) as T
        }
    }
}
