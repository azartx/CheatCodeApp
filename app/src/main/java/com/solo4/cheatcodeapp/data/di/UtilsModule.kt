package com.solo4.cheatcodeapp.data.di

import android.content.Context.MODE_PRIVATE
import com.solo4.cheatcodeapp.data.database.deserializers.CheatDeserializer
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val utilsModule = module {
    factory { androidApplication().getSharedPreferences("APP_PREFS", MODE_PRIVATE) }
    factory { CheatDeserializer() }
}
