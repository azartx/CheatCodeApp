package com.solo4.cheatcodeapp.model.cheats

import com.solo4.cheatcodeapp.R
import com.solo4.cheatcodeapp.domain.model.CheatCategory

sealed class UiCheatCategory {
    abstract val category: CheatCategory
    abstract val localizedNameResId: Int
    abstract val imageResId: Int

    data object Character : UiCheatCategory() {
        override val category: CheatCategory = CheatCategory.character
        override val localizedNameResId: Int = R.string.app_name
        override val imageResId: Int = R.drawable.img_category_character
    }

    data object Auto : UiCheatCategory() {
        override val category: CheatCategory = CheatCategory.auto
        override val localizedNameResId: Int = R.string.app_name
        override val imageResId: Int = R.drawable.img_category_car
    }

    companion object {
        val all by lazy { listOf(Character, Auto) }
    }
}
