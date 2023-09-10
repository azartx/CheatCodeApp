package com.solo4.cheatcodeapp.di.modules

import android.app.Application
import com.solo4.cheatcodeapp.data.datasource.CheatDatasource
import com.solo4.cheatcodeapp.data.datasource.CheatInfoDatasource
import com.solo4.cheatcodeapp.data.datasource.database.FirebaseCheatsDatabase
import com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo.CheatInfoDAO
import com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo.CheatsInfoDatabase
import com.solo4.cheatcodeapp.data.datasource.database.cheatsinfo.LocalCheatsInfoDatasource
import com.solo4.cheatcodeapp.data.repository.CheatSheetRepositoryImpl
import com.solo4.cheatcodeapp.data.repository.HomeRepositoryImpl
import com.solo4.cheatcodeapp.data.settings.settingsmanager.SettingsManager
import com.solo4.cheatcodeapp.data.settings.settingsmanager.impl.AppSettingsManagerImpl
import com.solo4.cheatcodeapp.domain.repositories.CheatSheetRepository
import com.solo4.cheatcodeapp.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DataModule.DataBinds::class, DataModule.RepoBinds::class])
object DataModule {
    @Provides
    fun provideCheatInfoDatabase(application: Application): CheatsInfoDatabase {
        return CheatsInfoDatabase.create(application)
    }

    @Provides
    fun provideCheatInfoDao(cheatsInfoDatabase: CheatsInfoDatabase): CheatInfoDAO {
        return cheatsInfoDatabase.cheatInfoDao()
    }

    @Provides
    fun provideLocalCheatsInfoDatasource(cheatsInfoDao: CheatInfoDAO): CheatInfoDatasource {
        return LocalCheatsInfoDatasource(cheatsInfoDao)
    }

    @Module
    interface DataBinds {
        @Binds
        fun bindCheatsDataStoreImplToCheatDataStore(dbImpl: FirebaseCheatsDatabase): CheatDatasource

        @Binds
        fun bindAppSettingsManagerImplToSettingsManager(appSettingsManagerImpl: AppSettingsManagerImpl): SettingsManager
    }

    @Module
    interface RepoBinds {
        @Binds
        fun bindHomeRepositoryImplToHomeRepository(homeRepoImpl: HomeRepositoryImpl): HomeRepository
        @Singleton
        @Binds
        fun bindCheatSheetRepositoryImplToCheatSheetRepository(
            cheatSheetRepositoryImpl: CheatSheetRepositoryImpl
        ): CheatSheetRepository
    }
}
