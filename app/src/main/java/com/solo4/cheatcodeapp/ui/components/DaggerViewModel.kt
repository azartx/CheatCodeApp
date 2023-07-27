package com.solo4.cheatcodeapp.ui.components

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.solo4.cheatcodeapp.data.di.AppComponent
import com.solo4.cheatcodeapp.data.di.appComponent

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline vmCreator: AppComponent.() -> T
): T {
    val _appComponent = appComponent
    return androidx.lifecycle.viewmodel.compose.viewModel(
        modelClass = T::class.java,
        key = key,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return vmCreator(_appComponent) as T
            }
        }
    )
}

@Composable
inline fun <reified T : ViewModel> daggerViewModel(
    key: String? = null,
    crossinline vmCreatorWithExtras: AppComponent.(CreationExtras) -> T
): T {
    val _appComponent = appComponent
    return androidx.lifecycle.viewmodel.compose.viewModel(key = key) {
        return@viewModel vmCreatorWithExtras.invoke(_appComponent, this)
    }
}
