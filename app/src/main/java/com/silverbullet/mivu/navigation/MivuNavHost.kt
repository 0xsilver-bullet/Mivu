package com.silverbullet.mivu.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.silverbullet.feature.auth.navigation.authenticationGraph

@ExperimentalAnimationApi
@Composable
fun MivuNavHost(navController: NavHostController, startDestination: String) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authenticationGraph(
            onLogin = {
                navController.navigateToMainFeaturesGraph()
            }
        )
        featuresGraph()
    }
}






