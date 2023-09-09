package com.solo4.cheatcodeapp.ui.screens.home

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solo4.cheatcodeapp.domain.model.PreferredPlatform
import com.solo4.cheatcodeapp.domain.repositories.HomeRepository
import com.solo4.cheatcodeapp.data.settings.settingsmanager.SettingsManager
import com.solo4.cheatcodeapp.domain.model.CheatEntity
import com.solo4.cheatcodeapp.domain.model.CheatCategory
import com.solo4.cheatcodeapp.mappers.CheatCategoryMapper
import com.solo4.cheatcodeapp.ui.base.AppVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeViewModel(
    application: Application,
    private val homeRepo: HomeRepository,
    private val appSettingsManager: SettingsManager,
    private val cheatCategoryMapper: CheatCategoryMapper
) : AppVM(application) {
    val preferredPlatform = appSettingsManager.preferredGamePlatform
    val cheats: MutableState<List<CheatEntity>> = mutableStateOf(emptyList())

    val categories = flow {
        emit(CheatCategory.entries.chunked(2)
            .map { categories ->
                Pair(
                    categories.firstOrNull()?.let { cheatCategoryMapper.toUi(it) },
                    categories.getOrNull(1)?.let { cheatCategoryMapper.toUi(it) }
                )
            })
    }.flowOn(Dispatchers.Default)

    fun changePreferredPlatform(newPlatform: PreferredPlatform) {
        launchMainScope {
            appSettingsManager.updatePreferredPlatform(newPlatform)
        }
    }

    fun requestPlatformCheats() {
        val disp = homeRepo.getPlatformCheats(preferredPlatform.value) // todo
            .subscribe { result, error ->
                if (result != null) {
                    cheats.value = result
                }
            }
    }

    class Factory @Inject constructor(
        private val application: Application,
        private val repo: HomeRepository,
        private val appSettingsManager: SettingsManager,
        private val cheatCategoryMapper: CheatCategoryMapper
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(application, repo, appSettingsManager, cheatCategoryMapper) as T
        }
    }
}
