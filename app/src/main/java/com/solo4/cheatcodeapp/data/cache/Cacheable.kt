package com.solo4.cheatcodeapp.data.cache

interface Cacheable<T : Any> {
    fun saveToCache(key: Any, data: List<T>): Boolean
    fun removeFromCache(key: Any): Boolean
    fun clearCache()
    fun restoreFromCache(key: Any): List<T>
}
