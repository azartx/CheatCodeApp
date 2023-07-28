package com.solo4.cheatcodeapp.model.cheats

import com.solo4.cheatcodeapp.R

sealed class CheatCategory {
    abstract val databaseName: String
    abstract val localizedNameResId: Int
    abstract val imageResId: Int

    data object Favourites: CheatCategory() {
        override val databaseName: String = "favourites"
        override val localizedNameResId: Int = R.string.app_name
        override val imageResId: Int = R.drawable.img_category_character
    }

    data object Character: CheatCategory() {
        override val databaseName: String = "character"
        override val localizedNameResId: Int = R.string.app_name
        override val imageResId: Int = R.drawable.img_category_character
    }

    data object Auto : CheatCategory() {
        override val databaseName: String = "auto"
        override val localizedNameResId: Int = R.string.app_name
        override val imageResId: Int = R.drawable.img_category_car
    }

    companion object {
        val all = listOf(
            Character, Auto
        )
    }
}
