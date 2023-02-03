package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.ResetPasswordScreen

const val resetPasswordRoute = "reset-password-route"

fun NavController.navigateToResetPasswordScreen(navOptions: NavOptions? = null) {
    this.navigate(resetPasswordRoute, navOptions)
}

fun NavGraphBuilder.resetPasswordScreen(
    onVerify: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(resetPasswordRoute) {
        ResetPasswordScreen(onVerify)
    }
    nestedGraphs()
}