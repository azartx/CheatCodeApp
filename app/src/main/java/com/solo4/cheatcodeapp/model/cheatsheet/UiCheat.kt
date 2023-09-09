package com.solo4.cheatcodeapp.model.cheatsheet

import com.solo4.cheatcodeapp.model.cheats.UiCheatCategory

data class UiCheat(
    val id: Int,
    val category: UiCheatCategory,
    val description: String,
    val guide: List<UiPlatformCommand>,
    val isFavourite: Boolean
)
