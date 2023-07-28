package com.solo4.cheatcodeapp.ui.screens.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.data.home.repository.HomeRepository
import com.solo4.cheatcodeapp.data.settings.settingsmanager.SettingsManager
import com.solo4.cheatcodeapp.model.cheats.CheatCategory
import com.solo4.cheatcodeapp.ui.base.AppVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class HomeViewModel(
    application: Application,
    private val homeRepo: HomeRepository,
    private val appSettingsManager: SettingsManager
) : AppVM(application) {
    val preferredPlatform = appSettingsManager.preferredGamePlatform

    val categories = flow {
        emit(CheatCategory.all.chunked(2).map { Pair(it.firstOrNull(), it.getOrNull(1)) })
    }.flowOn(Dispatchers.Default)

    fun changePreferredPlatform(newPlatform: PreferredPlatform) {
        viewModelScope.launch {
            appSettingsManager.updatePreferredPlatform(newPlatform)
        }
    }
    class Factory @Inject constructor(
        private val application: Application,
        private val repo: HomeRepository,
        private val appSettingsManager: SettingsManager
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(application, repo, appSettingsManager) as T
        }
    }
}
