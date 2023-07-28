package com.solo4.cheatcodeapp.data.home.repository

import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.Cheat

interface HomeRepository {
    suspend fun getPlatformCheats(platform: PreferredPlatform): List<Cheat>
}