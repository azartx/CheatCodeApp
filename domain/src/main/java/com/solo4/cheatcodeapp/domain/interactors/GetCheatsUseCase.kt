package com.solo4.cheatcodeapp.domain.interactors

import com.solo4.cheatcodeapp.domain.model.CheatEntity
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import io.reactivex.rxjava3.core.Single

class GetCheatsUseCase(private val repository: CheatSheetRepository) {
    fun execute(preferredPlatform: PreferredPlatform): Single<List<CheatEntity>> {
        return repository.getPlatformCheats(preferredPlatform)
    }
}
