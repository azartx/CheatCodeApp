package com.solo4.cheatcodeapp.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.solo4.cheatcodeapp.App
import com.solo4.cheatcodeapp.R
import com.solo4.cheatcodeapp.ui.navigation.extensions.titleResId
import com.solo4.cheatcodeapp.ui.screens.destinations.HomeScreenDestination
import com.solo4.cheatcodeapp.ui.theme.CheatCodeAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainActivityViewModel> {
        (this.applicationContext as App).appComponent.mainActivityViewModelFactory
    }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val engine = rememberNavHostEngine()
            val navController = engine.rememberNavController()

            val currentDestination by navController.appCurrentDestinationAsState()

            CheatCodeAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = currentDestination
                                        ?.let { stringResource(id = it.titleResId) } ?: ""
                                )
                            },
                            navigationIcon = {
                                if (currentDestination !is HomeScreenDestination) {
                                    Image(
                                        modifier = Modifier.clickable {
                                            navController.popBackStack()
                                        },
                                        painter = painterResource(id = R.drawable.ic_arrow_back),
                                        contentDescription = getString(R.string.button_back),
                                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary)
                                    )
                                }
                            }
                        )
                    },
                    containerColor = MaterialTheme.colorScheme.background
                ) { paddings ->
                    DestinationsNavHost(
                        navGraph = NavGraphs.root,
                        modifier = Modifier
                            .padding(paddings)
                            .fillMaxSize(),
                        engine = engine,
                        navController = navController
                    )
                }
            }
        }
    }
}
