package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.VerifyAccountScreen

internal const val verifyAccountRoute = "verify_account_route"

internal fun NavController.navigateToVerifyAccountScreen(navOptions: NavOptions? = null) {
    this.navigate(verifyAccountRoute, navOptions)
}

internal fun NavGraphBuilder.verifyAccountScreen(
    onVerified: () -> Unit,
) {
    composable(verifyAccountRoute) {
        VerifyAccountScreen(onVerified)
    }
}