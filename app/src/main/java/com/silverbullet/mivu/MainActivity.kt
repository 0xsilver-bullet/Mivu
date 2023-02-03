package com.silverbullet.mivu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.silverbullet.feature.auth.navigation.navigateToAuthenticationGraph
import com.silverbullet.mivu.ui.theme.MivuTheme
import com.silverbullet.mivu.navigation.MivuNavHost
import com.silverbullet.mivu.navigation.mainGraphRoute
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    private var keepSplash = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                keepSplash
            }
        }
        setContent {
            MivuTheme {
                val navController = rememberNavController()
                MivuNavHost(navController = navController, mainGraphRoute)
                LaunchedEffect(key1 = Unit) {
                    if(viewModel.isAuthenticationRequired()){
                        navController.navigateToAuthenticationGraph()
                    }
                    keepSplash = false
                }
            }
        }
    }
}