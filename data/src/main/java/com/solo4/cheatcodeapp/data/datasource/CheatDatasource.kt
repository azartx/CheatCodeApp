package com.solo4.cheatcodeapp.data.datasource

import com.solo4.cheatcodeapp.data.model.CheatDto
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import io.reactivex.rxjava3.core.Single

interface CheatDatasource {
    fun getPlatformCheats(preferredPlatform: PreferredPlatform): Single<List<CheatDto>>
}
