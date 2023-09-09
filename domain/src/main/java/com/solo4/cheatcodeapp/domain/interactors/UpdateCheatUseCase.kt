package com.solo4.cheatcodeapp.domain.interactors

import com.solo4.cheatcodeapp.domain.model.Cheat
import com.solo4.cheatcodeapp.domain.model.CheatInfo
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import io.reactivex.rxjava3.core.Completable

class UpdateCheatUseCase(private val repository: CheatSheetRepository) {
    fun execute(cheat: Cheat): Completable {
        return repository.updateCheatInfo(
            CheatInfo(
                id = cheat.id,
                isFavourite = cheat.isFavourite
            )
        )
    }
}
