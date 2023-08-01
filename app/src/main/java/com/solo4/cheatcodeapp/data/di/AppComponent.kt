package com.solo4.cheatcodeapp.data.di

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.solo4.cheatcodeapp.App
import com.solo4.cheatcodeapp.data.di.modules.DataModule
import com.solo4.cheatcodeapp.data.di.modules.RepoModule
import com.solo4.cheatcodeapp.data.di.modules.UtilsModule
import com.solo4.cheatcodeapp.data.di.modules.ViewModelModule
import com.solo4.cheatcodeapp.ui.screens.MainActivityViewModel
import com.solo4.cheatcodeapp.ui.screens.cheatsheet.CheatSheetViewModel
import com.solo4.cheatcodeapp.ui.screens.home.HomeViewModel
import dagger.BindsInstance
import dagger.Component

@Component(modules = [
    DataModule::class,
    RepoModule::class,
    UtilsModule::class,
    ViewModelModule::class
])
interface AppComponent {
    val app: Application

    val homeViewModelFactory: HomeViewModel.Factory
    val cheatSheetViewModelFactory: CheatSheetViewModel.Factory
    val mainActivityViewModelFactory: MainActivityViewModel.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun app(app: Application): Builder
        fun build(): AppComponent
    }
}

val appComponent: AppComponent; @Composable get() =
    (LocalContext.current.applicationContext as App).appComponent
