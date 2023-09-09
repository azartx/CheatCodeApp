package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.solo4.cheatcodeapp.domain.interactors.ObserveCheatsInfoUseCase
import com.solo4.cheatcodeapp.domain.model.Cheat
import com.solo4.cheatcodeapp.mappers.CheatMapper
import com.solo4.cheatcodeapp.mappers.CommandMapper
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.model.cheatsheet.UiCheat
import com.solo4.cheatcodeapp.ui.base.AppVM
import com.solo4.cheatcodeapp.ui.screens.navArgs
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class CheatSheetViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle,
    observeCheatsInfoUseCase: ObserveCheatsInfoUseCase,
    private val commandMapper: CommandMapper,
    private val cheatMapper: CheatMapper
) : AppVM(application) {

    private val disposableBag = CompositeDisposable()

    private val args = savedStateHandle.navArgs<CheatSheetArgs>()
    val cheats: MutableState<List<UiCheat>> = mutableStateOf(emptyList())

    init {
        /*launchIoScope {
            cheats.value = cheatSheetRepository.getPlatformCheats(args.platform)
                .filter { it.category.databaseName == args._category }
        }*/
        disposableBag.add(
            observeCheatsInfoUseCase.execute(args.platform)
                .subscribe { cheats ->
                    this.cheats.value = cheats.map { cheatMapper.toUi(args.platform, it) }
                }
        )
    }

    override fun onCleared() {
        if (!disposableBag.isDisposed) disposableBag.dispose()
        super.onCleared()
    }

    class Factory @Inject constructor(
        private val application: Application,
        private val observeCheatsInfoUseCase: ObserveCheatsInfoUseCase,
        private val commandMapper: CommandMapper,
        private val cheatMapper: CheatMapper
    ) : AbstractSavedStateViewModelFactory() {
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return CheatSheetViewModel(
                application,
                handle,
                observeCheatsInfoUseCase,
                commandMapper,
                cheatMapper
            ) as T
        }

        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            return CheatSheetViewModel(
                application,
                extras.createSavedStateHandle(),
                observeCheatsInfoUseCase,
                commandMapper,
                cheatMapper
            ) as T
        }
    }
}
