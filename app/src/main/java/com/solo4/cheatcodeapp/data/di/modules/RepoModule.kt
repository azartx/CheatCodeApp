package com.solo4.cheatcodeapp.data.di.modules

import com.solo4.cheatcodeapp.data.cheatsheet.CheatSheetRepository
import com.solo4.cheatcodeapp.data.cheatsheet.impl.CheatSheetRepositoryImpl
import com.solo4.cheatcodeapp.data.home.repository.HomeRepository
import com.solo4.cheatcodeapp.data.home.repository.impl.HomeRepositoryImpl
import dagger.Binds
import dagger.Module

//val repoModule = module {
//    single { HomeRepositoryImpl(get()) }
//}

@Module(includes = [RepoModule.RepoBinds::class])
object RepoModule {
    @Module
    interface RepoBinds {
        @Binds
        fun bindHomeRepositoryImplToHomeRepository(homeRepoImpl: HomeRepositoryImpl): HomeRepository
        @Binds
        fun bindCheatSheetRepositoryImplToCheatSheetRepository(
            cheatSheetRepositoryImpl: CheatSheetRepositoryImpl
        ): CheatSheetRepository
    }
}
