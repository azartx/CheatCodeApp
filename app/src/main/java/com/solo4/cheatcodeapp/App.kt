package com.solo4.cheatcodeapp

import android.app.Application
import com.solo4.cheatcodeapp.data.di.AppComponent
import com.solo4.cheatcodeapp.data.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder()
            .app(this)
            .build()
        /*startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, utilsModule, dataModule, repoModule))
        }*/
    }

    companion object {
        lateinit var app: App
    }
}
