package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.solo4.cheatcodeapp.data.cheatsheet.CheatSheetRepository
import com.solo4.cheatcodeapp.model.cheats.Cheat
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.ui.base.AppVM
import com.solo4.cheatcodeapp.ui.screens.navArgs
import javax.inject.Inject

class CheatSheetViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle,
    private val cheatSheetRepository: CheatSheetRepository
) : AppVM(application) {
    private val args = savedStateHandle.navArgs<CheatSheetArgs>()
    val cheats: MutableState<List<Cheat>> = mutableStateOf(emptyList())

    init {
        launchIoScope {
            cheats.value = cheatSheetRepository.getPlatformCheats(args.platform)
                .filter { it.category.databaseName == args._category }
        }
    }

    class Factory @Inject constructor(
        private val application: Application,
        private val cheatSheetRepository: CheatSheetRepository
    ) : AbstractSavedStateViewModelFactory() {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return CheatSheetViewModel(application, handle, cheatSheetRepository) as T
        }

        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return CheatSheetViewModel(application, extras.createSavedStateHandle(), cheatSheetRepository) as T
        }
    }
}
