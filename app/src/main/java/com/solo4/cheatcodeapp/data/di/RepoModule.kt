package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.database.RemoteDB
import com.solo4.cheatcodeapp.data.home.HomeRepository
import dagger.Module
import dagger.Provides
import org.koin.dsl.module

val repoModule = module {
    single { HomeRepository(get()) }
}

@Module
object RepoModule {
    @Provides
    fun provideHomeRepository(remoteDB: RemoteDB): HomeRepository {
        return HomeRepository(remoteDB)
    }
}
