package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.VerifyAccountScreen

const val verifyAccountRoute = "verify_account_route"

fun NavController.navigateToVerifyAccountScreen(navOptions: NavOptions? = null) {
    this.navigate(verifyAccountRoute, navOptions)
}

fun NavGraphBuilder.verifyAccountScreen(
    onVerified: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(verifyAccountRoute) {
        VerifyAccountScreen(onVerified)
    }
    nestedGraphs()
}