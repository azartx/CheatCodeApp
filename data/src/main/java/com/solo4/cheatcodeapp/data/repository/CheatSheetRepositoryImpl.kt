package com.solo4.cheatcodeapp.data.repository

import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import com.solo4.cheatcodeapp.data.datasource.CheatDatasource
import com.solo4.cheatcodeapp.data.datasource.CheatInfoDatasource
import com.solo4.cheatcodeapp.data.mappers.CheatInfoMapper
import com.solo4.cheatcodeapp.data.mappers.CheatMapper
import com.solo4.cheatcodeapp.domain.model.CheatInfo
import com.solo4.cheatcodeapp.domain.model.CheatEntity
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CheatSheetRepositoryImpl @Inject constructor(
    private val cheatInfoDataSource: CheatInfoDatasource,
    private val cheatsDataSource: CheatDatasource,
    private val cheatMapper: CheatMapper,
    private val cheatInfoMapper: CheatInfoMapper
) : CheatSheetRepository {
    override fun getPlatformCheats(platform: PreferredPlatform): Single<List<CheatEntity>> {
        return cheatsDataSource.getPlatformCheats(platform)
            .map { it.map { cheats -> cheatMapper.toDomain(cheats) } }
            .subscribeOn(Schedulers.io())
    }

    override fun getCheatsInfo(): Observable<List<CheatInfo>> {
        return cheatInfoDataSource.getAllCheatsInfo()
            .map { cheatsInfo -> cheatsInfo.map { cheatInfoMapper.mapToDomain(it) } }
    }

    override fun updateCheatInfo(cheatInfo: CheatInfo): Completable {
        return cheatInfoDataSource.updateCheatInfo(cheatInfoMapper.mapToData(cheatInfo))
    }
}
