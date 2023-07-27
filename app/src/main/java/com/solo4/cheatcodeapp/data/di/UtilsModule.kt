package com.solo4.cheatcodeapp.data.di

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.solo4.cheatcodeapp.App
import com.solo4.cheatcodeapp.data.database.deserializers.CheatDeserializer
import dagger.Module
import dagger.Provides
import dagger.Reusable
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import javax.inject.Singleton

val utilsModule = module {
    factory { androidApplication().getSharedPreferences("APP_PREFS", MODE_PRIVATE) }
    factory { CheatDeserializer() }
}

@Module
object UtilsModule {
    @Provides
    @Reusable
    fun providePreferences(): SharedPreferences {
        return App.app.getSharedPreferences("APP_PREFS", MODE_PRIVATE)
    }
}
