package com.solo4.cheatcodeapp.data.di

import com.solo4.cheatcodeapp.ui.screens.cheatsheet.CheatSheetViewModel
import com.solo4.cheatcodeapp.ui.screens.home.HomeViewModel
import dagger.Module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get(), get()) }
    viewModel { CheatSheetViewModel(get()) }
}

@Module
object ViewModelModule {
//    @Provides
//    fun provideHomeViewModel(homeRepository: HomeRepository, appSettingsManager: AppSettingsManager): HomeViewModel {
//        return HomeViewModel(homeRepository, appSettingsManager)
//    }
//
//    @Provides
//    fun provideCheatSheetViewModel(savedStateHandle: SavedStateHandle): CheatSheetViewModel {
//        return CheatSheetViewModel(savedStateHandle)
//    }
}
