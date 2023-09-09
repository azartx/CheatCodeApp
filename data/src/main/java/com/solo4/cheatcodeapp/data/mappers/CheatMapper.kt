package com.solo4.cheatcodeapp.data.mappers

import com.solo4.cheatcodeapp.data.model.CheatDto
import com.solo4.cheatcodeapp.domain.model.CheatCategory
import com.solo4.cheatcodeapp.domain.model.CheatEntity
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import javax.inject.Inject

class CheatMapper @Inject constructor() {
    fun toDomain(cheatDto: CheatDto): CheatEntity {
        return CheatEntity(
            id = cheatDto.id,
            category = CheatCategory.entries.first { it.name == cheatDto.category },
            description = cheatDto.description,
            guide = cheatDto.guide
        )
    }

    fun toData(cheat: CheatEntity, platform: PreferredPlatform): CheatDto {
        return CheatDto(
            cheat.id,
            cheat.category.name,
            cheat.description,
            platform,
            cheat.guide
        )
    }
}
