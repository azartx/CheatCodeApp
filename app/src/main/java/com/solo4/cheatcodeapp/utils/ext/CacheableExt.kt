package com.solo4.cheatcodeapp.utils.ext

import com.solo4.cheatcodeapp.domain.model.PreferredPlatform

/*inline fun <reified T : Any> Cacheable<T>.cacheOrElse(key: Any, defAction: () -> List<T>): List<T> {
    return this.restoreFromCache(key).ifEmpty(defAction)
}*/ // todo

val PreferredPlatform.cacheKey; get() = "$this-CHEATS_CACHE_KEY"
