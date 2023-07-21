package com.solo4.cheatcodeapp.data.settings

import android.content.SharedPreferences
import androidx.core.content.edit
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppSettingsManager(private val preferences: SharedPreferences) {

    private val _preferredGamePlatform = MutableStateFlow(preferredGamePlatformInternal)
    val preferredGamePlatform = _preferredGamePlatform.asStateFlow()

    private var preferredGamePlatformInternal: PreferredPlatform
        get() = PreferredPlatform.valueOf(
            preferences.getString(
                PREFERRED_PLATFORM_KEY,
                PreferredPlatform.NONE.name
            ) ?: PreferredPlatform.NONE.name
        )
        set(value) { preferences.edit { putString(PREFERRED_PLATFORM_KEY, value.name) } }

    suspend fun updatePreferredPlatform(newPlatform: PreferredPlatform) {
        preferredGamePlatformInternal = newPlatform
        _preferredGamePlatform.emit(newPlatform)
    }

    companion object {
        private const val PREFERRED_PLATFORM_KEY = "PREFERRED_PLATFORM_KEY"
    }
}
