package com.solo4.cheatcodeapp.data.home.repository.impl

import com.solo4.cheatcodeapp.data.database.CheatsDatabase
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.data.home.repository.HomeRepository
import com.solo4.cheatcodeapp.model.cheats.Cheat
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val database: CheatsDatabase) : HomeRepository {
    override suspend fun getPlatformCheats(platform: PreferredPlatform): List<Cheat> {
        return database.getPlatformCheats(platform)
    }
}
