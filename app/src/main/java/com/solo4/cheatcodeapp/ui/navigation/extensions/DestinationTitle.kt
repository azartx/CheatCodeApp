package com.solo4.cheatcodeapp.ui.navigation.extensions

import androidx.annotation.StringRes
import com.solo4.cheatcodeapp.R
import com.solo4.cheatcodeapp.ui.screens.destinations.CheatSheetScreenDestination
import com.solo4.cheatcodeapp.ui.screens.destinations.Destination
import com.solo4.cheatcodeapp.ui.screens.destinations.HomeScreenDestination

@get:StringRes
val Destination.titleResId
    get(): Int {
        return when (this) {
            HomeScreenDestination -> R.string.title_home
            CheatSheetScreenDestination -> R.string.title_cheat_sheet
        }
    }