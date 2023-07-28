package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.database.CheatsDatabase
import com.solo4.cheatcodeapp.data.database.impl.firebase.RemoteDB
import com.solo4.cheatcodeapp.data.settings.settingsmanager.SettingsManager
import com.solo4.cheatcodeapp.data.settings.settingsmanager.impl.AppSettingsManagerImpl
import dagger.Binds
import dagger.Module
import org.koin.dsl.module

val dataModule = module {
    single { RemoteDB(get()) }
    single { AppSettingsManagerImpl(get()) }
}

@Module(includes = [DataModule.DataBinds::class])
object DataModule {
    @Module
    interface DataBinds {
        @Binds
        fun bindCheatsDatabaseImplToCheatDatabase(dbImpl: RemoteDB): CheatsDatabase

        @Binds
        fun bindAppSettingsManagerImplToSettingsManager(appSettingsManagerImpl: AppSettingsManagerImpl): SettingsManager
    }
}
