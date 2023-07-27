package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.database.RemoteDB
import com.solo4.cheatcodeapp.data.settings.AppSettingsManager
import dagger.Module
import org.koin.dsl.module

val dataModule = module {
    single { RemoteDB(get()) }
    single { AppSettingsManager(get()) }
}

@Module()
object DataModule {
    /*@Provides
    fun provideRemoteDB(deserializer: CheatDeserializer): RemoteDB {
        return RemoteDB(deserializer)
    }

    @Provides
    fun provideAppSettingsManager(prefs: SharedPreferences): AppSettingsManager {
        return AppSettingsManager(prefs)
    }*/
}
