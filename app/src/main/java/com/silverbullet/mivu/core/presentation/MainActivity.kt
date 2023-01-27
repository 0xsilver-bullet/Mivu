package com.silverbullet.mivu.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.silverbullet.mivu.core.presentation.ui.theme.MivuTheme
import com.silverbullet.mivu.navigation.MivuNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.startDestination.value == null
            }
        }
        setContent {
            MivuTheme {
                Surface {
                    val navController = rememberNavController()
                    val startDestination = viewModel.startDestination.collectAsState()
                    startDestination.value?.let { startDestinationRoute ->
                        MivuNavHost(navHostController = navController, startDestinationRoute)
                    }
                }
            }
        }
    }
}