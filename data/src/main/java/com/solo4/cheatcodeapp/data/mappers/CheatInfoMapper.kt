package com.solo4.cheatcodeapp.data.mappers

import com.solo4.cheatcodeapp.data.model.CheatInfoDto
import com.solo4.cheatcodeapp.domain.model.CheatInfo
import javax.inject.Inject

class CheatInfoMapper @Inject constructor() {
    fun mapToDomain(cheatInfoDto: CheatInfoDto): CheatInfo {
        return CheatInfo(
            id = cheatInfoDto.id,
            isFavourite = cheatInfoDto.isFavourite
        )
    }

    fun mapToData(cheatInfoDto: CheatInfo): CheatInfoDto {
        return CheatInfoDto(
            id = cheatInfoDto.id,
            isFavourite = cheatInfoDto.isFavourite
        )
    }
}
