package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import android.app.Application
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.solo4.cheatcodeapp.domain.interactors.ObserveCheatsInfoUseCase
import com.solo4.cheatcodeapp.domain.interactors.UpdateCheatUseCase
import com.solo4.cheatcodeapp.mappers.CheatMapper
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.model.cheatsheet.UiCheat
import com.solo4.cheatcodeapp.ui.base.AppVM
import com.solo4.cheatcodeapp.ui.screens.navArgs
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CheatSheetViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle,
    observeCheatsInfoUseCase: ObserveCheatsInfoUseCase,
    private val updateCheatInfoUseCase: UpdateCheatUseCase,
    private val cheatMapper: CheatMapper
) : AppVM(application) {

    private val disposableBag = CompositeDisposable()

    private val args = savedStateHandle.navArgs<CheatSheetArgs>()
    val cheats: MutableState<List<UiCheat>> = mutableStateOf(emptyList())

    init {
        disposableBag.add(
            observeCheatsInfoUseCase.execute(args.platform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { cheats ->
                    this.cheats.value = cheats.map { cheatMapper.toUi(args.platform, it) }
                }
        )
    }

    fun onCheatFavouriteIconClicked(cheat: UiCheat) {
        disposableBag.add(
            updateCheatInfoUseCase.execute(
                cheatMapper.toDomain(
                    args.platform,
                    cheat.copy(isFavourite = !cheat.isFavourite))
            )
                .subscribe(
                    {
                        Log.e("ffff", "ONCOMPLETE")
                    },
                    {

                        Log.e("ffff", "ONERROR", it)
                    }
                )
        )
    }

    override fun onCleared() {
        if (!disposableBag.isDisposed) disposableBag.dispose()
        super.onCleared()
    }

    class Factory @Inject constructor(
        private val application: Application,
        private val observeCheatsInfoUseCase: ObserveCheatsInfoUseCase,
        private val updateCheatInfoUseCase: UpdateCheatUseCase,
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
                updateCheatInfoUseCase,
                cheatMapper
            ) as T
        }
    }
}
