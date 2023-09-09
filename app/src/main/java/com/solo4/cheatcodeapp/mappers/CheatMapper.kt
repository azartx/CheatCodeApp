package com.solo4.cheatcodeapp.mappers

import com.solo4.cheatcodeapp.domain.model.Cheat
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
}
