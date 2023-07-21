package com.solo4.cheatcodeapp.model.cheats

import com.solo4.cheatcodeapp.R

sealed class CheatCategory {
    abstract val databaseName: String
    abstract val localizedNameId: Int

    data object Favourites: CheatCategory() {
        override val databaseName: String = "favourites"
        override val localizedNameId: Int = R.string.app_name
    }

    data object Character: CheatCategory() {
        override val databaseName: String = "character"
        override val localizedNameId: Int = R.string.app_name
    }

    data object Auto : CheatCategory() {
        override val databaseName: String = "auto"
        override val localizedNameId: Int = R.string.app_name
    }

    companion object {
        val all = listOf(
            Character, Auto
        )
    }
}
