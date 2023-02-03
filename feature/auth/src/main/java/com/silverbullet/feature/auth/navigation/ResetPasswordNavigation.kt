package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.ResetPasswordScreen

internal const val resetPasswordRoute = "reset-password-route"

internal fun NavController.navigateToResetPasswordScreen(navOptions: NavOptions? = null) {
    this.navigate(resetPasswordRoute, navOptions)
}

internal fun NavGraphBuilder.resetPasswordScreen(
    onVerify: () -> Unit,
) {
    composable(resetPasswordRoute) {
        ResetPasswordScreen(onVerify)
    }
}