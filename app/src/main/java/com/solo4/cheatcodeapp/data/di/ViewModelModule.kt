package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.ui.screens.cheatsheet.CheatSheetViewModel
import com.solo4.cheatcodeapp.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CheatSheetViewModel(get()) }
}
