package com.solo4.cheatcodeapp.data.datasource

import com.solo4.cheatcodeapp.data.model.CheatInfoDto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface CheatInfoDatasource {
    fun getAllCheatsInfo(): Observable<List<CheatInfoDto>>

    fun updateCheatInfo(cheatInfo: CheatInfoDto): Completable
}
