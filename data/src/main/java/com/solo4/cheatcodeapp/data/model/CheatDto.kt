package com.solo4.cheatcodeapp.data.model

import com.solo4.cheatcodeapp.domain.model.PlatformCommand
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform

data class CheatDto(
    val id: Int,
    val category: String,
    val description: String,
    val platform: PreferredPlatform,
    val guide: List<PlatformCommand>
)
