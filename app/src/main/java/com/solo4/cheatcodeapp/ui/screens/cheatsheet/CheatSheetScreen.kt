package com.solo4.cheatcodeapp.ui.screens.cheatsheet

import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.model.cheats.CheatCategory
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun CheatSheetScreen(navigator: DestinationsNavigator, platform: PreferredPlatform, _category: String) {
    val viewModel: CheatSheetViewModel = koinViewModel()
    val category = CheatCategory.all.first { it.databaseName == _category }

    
}
