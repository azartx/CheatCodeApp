package com.solo4.cheatcodeapp.data.repository

import com.solo4.cheatcodeapp.data.datasource.CheatDatasource
import com.solo4.cheatcodeapp.data.mappers.CheatMapper
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.domain.repositories.HomeRepository
import com.solo4.cheatcodeapp.domain.model.CheatEntity
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val cheatsDataSource: CheatDatasource,
    private val cheatMapper: CheatMapper,
) : HomeRepository {
    override fun getPlatformCheats(platform: PreferredPlatform): Single<List<CheatEntity>> {
        return cheatsDataSource.getPlatformCheats(platform)
            .map { it.map { cheats -> cheatMapper.toDomain(cheats) } }
            .subscribeOn(Schedulers.io())
    }
}
