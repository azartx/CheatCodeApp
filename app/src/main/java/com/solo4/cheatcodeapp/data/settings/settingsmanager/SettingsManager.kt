package com.solo4.cheatcodeapp.data.settings.settingsmanager

import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import kotlinx.coroutines.flow.StateFlow

interface SettingsManager {
    val preferredGamePlatform: StateFlow<PreferredPlatform>

    suspend fun updatePreferredPlatform(newPlatform: PreferredPlatform)
}
