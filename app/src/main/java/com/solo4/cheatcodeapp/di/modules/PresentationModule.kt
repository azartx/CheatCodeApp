package com.solo4.cheatcodeapp.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object PresentationModule {
    @Provides
    @Reusable
    fun provideAppPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("APP_PREFS", Context.MODE_PRIVATE)
    }
}
