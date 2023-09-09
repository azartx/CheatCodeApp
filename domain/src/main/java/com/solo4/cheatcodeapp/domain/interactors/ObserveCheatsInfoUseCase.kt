package com.solo4.cheatcodeapp.domain.interactors

import com.solo4.cheatcodeapp.domain.model.Cheat
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import io.reactivex.rxjava3.core.Observable

class ObserveCheatsInfoUseCase(private val repository: CheatSheetRepository) {
    fun execute(preferredPlatform: PreferredPlatform): Observable<List<Cheat>> {
        return repository.getCheatsInfo()
            .zipWith(repository.getPlatformCheats(preferredPlatform).toObservable()) { cheatInfos, cheatEntities ->
                cheatEntities.map { cheatEntity ->
                    Cheat(
                        id = cheatEntity.id,
                        category = cheatEntity.category,
                        description = cheatEntity.description,
                        guide = cheatEntity.guide,
                        isFavourite = cheatInfos
                            .firstOrNull { it.id == cheatEntity.id }?.isFavourite ?: false
                    )
                }
            }
    }
}
