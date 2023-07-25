package com.solo4.cheatcodeapp.data.di

import dagger.Component

@Component(modules = [DataModule::class, RepoModule::class, UtilsModule::class, ViewModelModule::class])
interface AppComponent {

}
