package com.solo4.cheatcodeapp.mappers

import com.solo4.cheatcodeapp.domain.model.Cheat
import com.solo4.cheatcodeapp.domain.model.CheatCategory
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.UiCheatCategory
import com.solo4.cheatcodeapp.model.cheatsheet.UiCheat
import javax.inject.Inject

class CheatMapper @Inject constructor(private val commandMapper: CommandMapper) {
    fun toUi(preferredPlatform: PreferredPlatform, cheat: Cheat): UiCheat {
        return UiCheat(
            id = cheat.id,
            category = UiCheatCategory.all.first { it.category == cheat.category },
            description = cheat.description,
            guide = commandMapper.toUi(preferredPlatform, cheat.guide),
            isFavourite = cheat.isFavourite
        )
    }

    fun toDomain(preferredPlatform: PreferredPlatform, uiCheat: UiCheat): Cheat {
        return Cheat(
            id = uiCheat.id,
            category = CheatCategory.entries.first { it == uiCheat.category.category },
            description = uiCheat.description,
            guide = commandMapper.toDomain(preferredPlatform, uiCheat.guide),
            isFavourite = uiCheat.isFavourite
        )
    }
}
