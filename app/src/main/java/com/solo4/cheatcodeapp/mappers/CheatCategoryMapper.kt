package com.solo4.cheatcodeapp.mappers

import com.solo4.cheatcodeapp.domain.model.CheatCategory
import com.solo4.cheatcodeapp.model.cheats.UiCheatCategory
import javax.inject.Inject

class CheatCategoryMapper @Inject constructor() {
    fun toDomain(uiCheatCategory: UiCheatCategory): CheatCategory {
        return uiCheatCategory.category
    }

    fun toUi(cheatCategory: CheatCategory): UiCheatCategory {
        return when (cheatCategory) {
            CheatCategory.character -> UiCheatCategory.Character
            CheatCategory.auto -> UiCheatCategory.Auto
            else -> throw NotImplementedError(
                "Category ${cheatCategory.name} is not implemented in UiCheatCategory"
            )
        }
    }
}
