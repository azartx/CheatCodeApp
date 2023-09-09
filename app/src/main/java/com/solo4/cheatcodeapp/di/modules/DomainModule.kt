package com.solo4.cheatcodeapp.di.modules

import com.solo4.cheatcodeapp.domain.interactors.ObserveCheatsInfoUseCase
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import dagger.Module
import dagger.Provides

@Module
object DomainModule {
    @Provides
    fun provideObserveCheatsUseCase(cheatSheetRepository: CheatSheetRepository): ObserveCheatsInfoUseCase {
        return ObserveCheatsInfoUseCase(cheatSheetRepository)
    }
}
