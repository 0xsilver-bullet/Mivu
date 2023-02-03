package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.StartScreen

const val startRoute = "start_route"

fun NavController.navigateToStartScreen(navOptions: NavOptions? = null) {
    this.navigate(startRoute, navOptions)
}

fun NavGraphBuilder.startScreen(
    onLogin: () -> Unit,
    onSignup: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(startRoute) {
        StartScreen(onLogin, onSignup)
    }
    nestedGraphs()
}