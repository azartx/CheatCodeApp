package com.solo4.cheatcodeapp

import android.app.Application
import com.solo4.cheatcodeapp.data.di.DaggerAppComponent
import com.solo4.cheatcodeapp.data.di.dataModule
import com.solo4.cheatcodeapp.data.di.repoModule
import com.solo4.cheatcodeapp.data.di.utilsModule
import com.solo4.cheatcodeapp.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
        /*startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, utilsModule, dataModule, repoModule))
        }*/
    }
}
