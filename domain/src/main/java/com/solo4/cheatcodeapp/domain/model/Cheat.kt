package com.solo4.cheatcodeapp.domain.model

data class Cheat(
    val id: Int,
    val category: CheatCategory,
    val description: String,
    val guide: List<PlatformCommand>,
    val isFavourite: Boolean
)
