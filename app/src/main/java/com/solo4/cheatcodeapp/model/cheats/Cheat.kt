package com.solo4.cheatcodeapp.model.cheats

data class Cheat(
    val id: Int,
    val category: CheatCategory,
    val description: String,
    val guide: List<String>
)
