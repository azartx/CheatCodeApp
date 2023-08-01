package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.cache.Cacheable
import com.solo4.cheatcodeapp.data.cache.impl.cheats.CheatCache
import com.solo4.cheatcodeapp.data.database.CheatsDataSource
import com.solo4.cheatcodeapp.data.database.impl.firebase.RemoteDB
import com.solo4.cheatcodeapp.data.settings.settingsmanager.SettingsManager
import com.solo4.cheatcodeapp.data.settings.settingsmanager.impl.AppSettingsManagerImpl
import com.solo4.cheatcodeapp.model.cheats.Cheat
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*val dataModule = module {
    single { RemoteDB(get()) }
    single { AppSettingsManagerImpl(get()) }
}*/

@Module(includes = [DataModule.DataBinds::class])
object DataModule {
    @Provides
    @Singleton
    @CheatCacheQualifier
    fun provideCheatCache(): CheatCache { return CheatCache() }
    @Module
    interface DataBinds {
        @Binds
        fun bindCheatsDataStoreImplToCheatDataStore(dbImpl: RemoteDB): CheatsDataSource

        @Binds
        fun bindAppSettingsManagerImplToSettingsManager(appSettingsManagerImpl: AppSettingsManagerImpl): SettingsManager
        @CheatCacheQualifier
        @Binds
        fun bindCheatCacheToCacheable(cheatCache: CheatCache): Cacheable<Cheat>
    }
}
