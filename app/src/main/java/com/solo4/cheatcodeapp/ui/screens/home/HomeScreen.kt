package com.solo4.cheatcodeapp.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.ui.screens.destinations.CheatSheetScreenDestination
import org.koin.androidx.compose.koinViewModel

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    val viewModel: HomeViewModel = koinViewModel()

    val preferredPlatform by viewModel.preferredPlatform.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        if (preferredPlatform == PreferredPlatform.NONE) {
            Spacer(modifier = Modifier.height(28.dp))
            Text(text = "Choose the platform on which you play GTA")
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { viewModel.changePreferredPlatform(PreferredPlatform.PLAY_STATION) }) {
                    Text(text = "Play Station")
                }
                Button(onClick = { viewModel.changePreferredPlatform(PreferredPlatform.XBOX) }) {
                    Text(text = "XBOX")
                }
                Button(onClick = { viewModel.changePreferredPlatform(PreferredPlatform.PC) }) {
                    Text(text = "PC")
                }
            }
        } else {
            viewModel.getCategories().forEach { twoCategoriesRow ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(modifier = Modifier.weight(1f), onClick = {
                        navigator.navigate(CheatSheetScreenDestination(preferredPlatform, twoCategoriesRow.first().databaseName))
                    }) {
                        Text(text = stringResource(id = twoCategoriesRow.first().localizedNameId))
                    }
                    twoCategoriesRow.getOrNull(1)?.let { secondCategory ->
                        Button(modifier = Modifier.weight(1f), onClick = {
                            navigator.navigate(CheatSheetScreenDestination(preferredPlatform, secondCategory.databaseName))
                        }) {
                            Text(text = stringResource(id = secondCategory.localizedNameId))
                        }
                    }
                }
            }
        }
    }
}
