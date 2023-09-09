package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.solo4.cheatcodeapp.model.cheatsheet.CheatSheetArgs
import com.solo4.cheatcodeapp.ui.components.ConsoleSheetItem
import com.solo4.cheatcodeapp.ui.components.daggerViewModel

@Destination(navArgsDelegate = CheatSheetArgs::class)
@Composable
fun CheatSheetScreen() {
    val viewModel: CheatSheetViewModel = daggerViewModel(
        vmCreatorWithExtras = { cheatSheetViewModelFactory.create(CheatSheetViewModel::class.java, it) }
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            content = {
                items(viewModel.cheats.value) { cheat ->
                    ConsoleSheetItem(
                        Modifier,
                        cheat,
                        onFavoriteClick = {
                            viewModel.onCheatFavouriteIconClicked(cheat)
                        },
                        onClick = {

                        }
                    )
                }
        })
    }
}
