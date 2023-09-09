package com.solo4.cheatcodeapp.domain.repositories

import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.domain.model.CheatEntity
import io.reactivex.rxjava3.core.Single

interface HomeRepository {
    fun getPlatformCheats(platform: PreferredPlatform): Single<List<CheatEntity>>
}