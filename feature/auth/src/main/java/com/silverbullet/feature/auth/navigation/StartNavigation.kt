package com.silverbullet.feature.auth.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.StartScreen

internal const val startRoute = "start_route"


fun NavGraphBuilder.startScreen(
    onLogin: () -> Unit,
    onSignup: () -> Unit,
) {
    composable(startRoute) {
        StartScreen(onLogin, onSignup)
    }
}