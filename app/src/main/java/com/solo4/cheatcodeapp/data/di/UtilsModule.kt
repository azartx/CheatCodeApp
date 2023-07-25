package com.solo4.cheatcodeapp.data.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.solo4.cheatcodeapp.data.database.deserializers.CheatDeserializer
import dagger.Module
import dagger.Provides
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val utilsModule = module {
    factory { androidApplication().getSharedPreferences("APP_PREFS", MODE_PRIVATE) }
    factory { CheatDeserializer() }
}

@Module
object UtilsModule {
    @Provides
    fun providePreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("APP_PREFS", MODE_PRIVATE)
    }
}
