package com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo

import com.solo4.cheatcodeapp.data.datasource.CheatInfoDatasource
import com.solo4.cheatcodeapp.data.model.CheatInfoDto
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

class LocalCheatsInfoDatasource(private val cheatsInfoDAO: CheatInfoDAO) : CheatInfoDatasource {
    override fun getAllCheatsInfo(): Observable<List<CheatInfoDto>> {
        return cheatsInfoDAO.getAllCheatsInfo()
    }

    override fun updateCheatInfo(cheatInfo: CheatInfoDto): Completable {
        return cheatsInfoDAO.updateCheatInfo(cheatInfo)
    }
}
