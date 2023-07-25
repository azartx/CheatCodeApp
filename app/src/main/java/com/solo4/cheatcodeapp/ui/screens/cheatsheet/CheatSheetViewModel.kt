package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import androidx.lifecycle.SavedStateHandle
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.ui.base.AppVM
import com.solo4.cheatcodeapp.ui.screens.navArgs
import javax.inject.Inject

class CheatSheetViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : AppVM() {
    private val args = savedStateHandle.navArgs<CheatSheetArgs>()


}
