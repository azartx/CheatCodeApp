package com.solo4.cheatcodeapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.solo4.cheatcodeapp.R
import com.solo4.cheatcodeapp.data.home.PreferredPlatform
import com.solo4.cheatcodeapp.ui.components.daggerViewModel
import com.solo4.cheatcodeapp.ui.screens.destinations.CheatSheetScreenDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {
    val viewModel: HomeViewModel = daggerViewModel(
        vmCreatorWithExtras = { this.homeViewModelFactory.create(HomeViewModel::class.java) }
    )
    val preferredPlatform by viewModel.preferredPlatform.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        if (preferredPlatform == PreferredPlatform.NONE) {
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(R.string.home_title_choice_platform)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f)
                        .clickable(
                            indication = rememberRipple(radius = 50.dp),
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                viewModel.changePreferredPlatform(PreferredPlatform.XBOX)
                            }
                        ),
                    painter = painterResource(id = R.drawable.ic_home_platform_xbox),
                    contentDescription = stringResource(R.string.platform_xbox)
                )
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f)
                        .clickable(
                            indication = rememberRipple(radius = 50.dp),
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                viewModel.changePreferredPlatform(PreferredPlatform.PLAY_STATION)
                            }
                        ),
                    painter = painterResource(id = R.drawable.ic_home_platform_ps),
                    contentDescription = stringResource(R.string.platform_playstation)
                )
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .weight(1f)
                        .clickable(
                            indication = rememberRipple(radius = 50.dp),
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = {
                                viewModel.changePreferredPlatform(PreferredPlatform.PC)
                            }
                        ),
                    painter = painterResource(id = R.drawable.ic_home_platform_pc),
                    contentDescription = stringResource(R.string.platform_pc)
                )
            }
        } else {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(R.string.hpme_title_choice_category)
            )
            viewModel.categories.collectAsState(emptyList()).value.forEach { categoriesPair ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    categoriesPair.first?.let { category ->
                        Image(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    navigator.navigate(
                                        CheatSheetScreenDestination(
                                            preferredPlatform,
                                            category.databaseName
                                        )
                                    )
                                },
                            painter = painterResource(id = category.imageResId),
                            contentDescription = stringResource(id = category.localizedNameResId)
                        )
                    }
                    categoriesPair.second?.let { category ->
                        Image(
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    navigator.navigate(
                                        CheatSheetScreenDestination(
                                            preferredPlatform,
                                            category.databaseName
                                        )
                                    )
                                },
                            painter = painterResource(id = category.imageResId),
                            contentDescription = stringResource(id = category.localizedNameResId)
                        )
                    }
                }
            }
        }
    }
}
