package com.solo4.cheatcodeapp.model.cheatsheet

import com.solo4.cheatcodeapp.model.cheats.Cheat

data class CheatSheetItem(
    val cheat: Cheat,
    val isFavourite: Boolean
)
