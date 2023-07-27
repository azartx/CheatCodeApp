package com.solo4.cheatcodeapp.data.home

import com.solo4.cheatcodeapp.data.database.RemoteDB
import com.solo4.cheatcodeapp.model.cheats.Cheat
import javax.inject.Inject

class HomeRepository @Inject constructor(private val database: RemoteDB) {
    suspend fun getPlatformCheats(platform: PreferredPlatform): List<Cheat> {
        return database.getPlatformCheats(platform)
    }
}
