package com.solo4.cheatcodeapp.data.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.solo4.cheatcodeapp.App
import com.solo4.cheatcodeapp.ui.screens.cheatsheet.CheatSheetViewModel
import com.solo4.cheatcodeapp.ui.screens.home.HomeViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    DataModule::class,
    RepoModule::class,
    UtilsModule::class,
    ViewModelModule::class
],
dependencies = [AppComponent.AppDeps::class])
interface AppComponent {
    val deps: AppDeps

    val homeViewModelFactory: HomeViewModel.Factory
    val cheatSheetViewModelFactory: CheatSheetViewModel.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appDeps(deps: AppDeps): Builder
        fun build(): AppComponent
    }

    interface AppDeps {
        val app: App
    }
}

val appComponent: AppComponent; @Composable get() =
    (LocalContext.current.applicationContext as App).appComponent
