package com.solo4.cheatcodeapp.data.cheatsheet

import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.Cheat

interface CheatSheetRepository {
    suspend fun getPlatformCheats(platform: PreferredPlatform): List<Cheat>
}
