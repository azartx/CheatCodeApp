package com.solo4.cheatcodeapp.data.database

import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.Cheat

interface CheatsDatabase {
    suspend fun getPlatformCheats(preferredPlatform: PreferredPlatform): List<Cheat>
}
