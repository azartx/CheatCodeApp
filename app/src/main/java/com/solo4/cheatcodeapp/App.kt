package com.solo4.cheatcodeapp

import android.app.Application
import com.solo4.cheatcodeapp.di.AppComponent
import com.solo4.cheatcodeapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder()
            .app(this)
            .build()
    }

    companion object {
        lateinit var app: App
    }
}
