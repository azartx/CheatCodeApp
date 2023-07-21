package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.database.RemoteDB
import com.solo4.cheatcodeapp.data.settings.AppSettingsManager
import org.koin.dsl.module

val dataModule = module {
    single { RemoteDB(get()) }
    single { AppSettingsManager(get()) }
}
