package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import android.app.Application
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.ui.base.AppVM
import com.solo4.cheatcodeapp.ui.screens.navArgs
import javax.inject.Inject

class CheatSheetViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle
) : AppVM(application) {
    private val args = savedStateHandle.navArgs<CheatSheetArgs>()

    class Factory @Inject constructor(
        private val application: Application
    ) : AbstractSavedStateViewModelFactory() {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return CheatSheetViewModel(application, handle) as T
        }

        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return CheatSheetViewModel(application, extras.createSavedStateHandle()) as T
        }
    }
}
