package com.solo4.cheatcodeapp.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.solo4.cheatcodeapp.data.home.HomeRepository
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.data.settings.AppSettingsManager
import com.solo4.cheatcodeapp.model.cheats.CheatCategory
import com.solo4.cheatcodeapp.ui.base.AppVM
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repo: HomeRepository,
    private val appSettingsManager: AppSettingsManager
) : AppVM() {
    val preferredPlatform = appSettingsManager.preferredGamePlatform

    fun changePreferredPlatform(newPlatform: PreferredPlatform) {
        viewModelScope.launch {
            appSettingsManager.updatePreferredPlatform(newPlatform)
        }
    }

    fun getCategories() = CheatCategory.all.chunked(2)
}
