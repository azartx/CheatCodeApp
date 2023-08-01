package com.solo4.cheatcodeapp.data.home.repository.impl

import com.solo4.cheatcodeapp.data.cache.Cacheable
import com.solo4.cheatcodeapp.data.database.CheatsDataSource
import com.solo4.cheatcodeapp.data.di.CheatCacheQualifier
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.data.home.repository.HomeRepository
import com.solo4.cheatcodeapp.model.cheats.Cheat
import com.solo4.cheatcodeapp.utils.ext.cacheKey
import com.solo4.cheatcodeapp.utils.ext.cacheOrElse
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    @CheatCacheQualifier private val cheatCache: Cacheable<Cheat>,
    private val cheatsDataSource: CheatsDataSource
) : HomeRepository {
    override suspend fun getPlatformCheats(platform: PreferredPlatform): List<Cheat> {
        return cheatCache.cacheOrElse(key = platform.cacheKey) {
            cheatsDataSource.getPlatformCheats(platform).apply {
                cheatCache.saveToCache(platform.cacheKey, this)
            }
        }
    }
}
