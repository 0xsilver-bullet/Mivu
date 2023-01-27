package com.silverbullet.mivu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.silverbullet.mivu.feature_auth.presentation.StartScreen

@Composable
fun MivuNavHost(navHostController: NavHostController, startDestination: String) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {

        composable(Screen.StartScreen.route) {
            StartScreen(navController = navHostController)
        }

    }
}