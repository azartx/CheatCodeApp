package com.solo4.cheatcodeapp.data.di.modules

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.solo4.cheatcodeapp.App
import dagger.Module
import dagger.Provides
import dagger.Reusable

/*val utilsModule = module {
    factory { androidApplication().getSharedPreferences("APP_PREFS", MODE_PRIVATE) }
    factory { CheatDeserializer() }
}*/

@Module
object UtilsModule {
    @Provides
    @Reusable
    fun providePreferences(): SharedPreferences {
        return App.app.getSharedPreferences("APP_PREFS", MODE_PRIVATE)
    }
}
