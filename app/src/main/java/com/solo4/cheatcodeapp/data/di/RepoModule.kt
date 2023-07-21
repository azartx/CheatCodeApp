package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.data.home.HomeRepository
import org.koin.dsl.module

val repoModule = module {
    single { HomeRepository(get()) }
}
