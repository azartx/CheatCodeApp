package com.solo4.cheatcodeapp.domain.repositories

import com.solo4.cheatcodeapp.domain.model.CheatEntity
import com.solo4.cheatcodeapp.domain.model.CheatInfo
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CheatSheetRepository {
    fun getPlatformCheats(platform: PreferredPlatform): Single<List<CheatEntity>>
    fun getCheatsInfo(): Observable<List<CheatInfo>>
    fun updateCheatInfo(cheatInfo: CheatInfo): Completable
}
