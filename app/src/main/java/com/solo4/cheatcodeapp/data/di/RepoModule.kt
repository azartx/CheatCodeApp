package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.home.repository.HomeRepository
import com.solo4.cheatcodeapp.data.home.repository.impl.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import org.koin.dsl.module

val repoModule = module {
    single { HomeRepositoryImpl(get()) }
}

@Module(includes = [RepoModule.RepoBinds::class])
object RepoModule {
    @Module
    interface RepoBinds {
        @Binds
        fun bindHomeRepositoryImplToHomeRepository(homeRepoImpl: HomeRepositoryImpl): HomeRepository
    }
}
