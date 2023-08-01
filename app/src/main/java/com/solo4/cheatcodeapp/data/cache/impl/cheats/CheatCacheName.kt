package com.solo4.cheatcodeapp.data.cache.impl.cheats

import com.solo4.cheatcodeapp.data.cache.Cacheable
import com.solo4.cheatcodeapp.model.cheats.Cheat
import java.util.Collections
import javax.inject.Inject

class CheatCache @Inject constructor() : Cacheable<Cheat> {
    private val cheatSheetCacheMap: MutableMap<Any, List<Cheat>> =
        Collections.synchronizedMap(hashMapOf())
    override fun saveToCache(key: Any, data: List<Cheat>): Boolean {
        return cheatSheetCacheMap.put(key, data) != null
    }

    override fun removeFromCache(key: Any): Boolean {
        return cheatSheetCacheMap.remove(key) != null
    }

    override fun clearCache() {
        cheatSheetCacheMap.clear()
    }

    override fun restoreFromCache(key: Any): List<Cheat> {
        return cheatSheetCacheMap[key] ?: emptyList()
    }
}
