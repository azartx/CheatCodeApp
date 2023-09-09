package com.solo4.cheatcodeapp.domain.interactors

import com.solo4.cheatcodeapp.domain.model.CheatInfo
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import io.reactivex.rxjava3.core.Completable

class UpdateCheatInfoUseCase(private val repository: CheatSheetRepository) {
    fun execute(cheatInfo: CheatInfo): Completable {
        return repository.updateCheatInfo(cheatInfo)
    }
}
