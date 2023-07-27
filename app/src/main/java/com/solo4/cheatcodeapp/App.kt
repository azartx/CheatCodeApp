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
            .appDeps(AppDepsImpl())
            .build()
        /*startKoin {
            androidContext(this@App)
            modules(listOf(viewModelModule, utilsModule, dataModule, repoModule))
        }*/
    }

    private inner class AppDepsImpl : AppComponent.AppDeps {
        override val app: App = this@App
    }

    companion object {
        lateinit var app: App
    }
}
