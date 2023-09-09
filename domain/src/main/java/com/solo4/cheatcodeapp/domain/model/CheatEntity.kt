package com.solo4.cheatcodeapp.domain.model

data class CheatEntity(
    val id: Int,
    val category: CheatCategory,
    val description: String,
    val guide: List<PlatformCommand>
)
