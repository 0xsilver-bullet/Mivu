package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.SignupScreen

internal const val signupRoute = "signup_route"

internal fun NavController.navigateToSignupScreen(navOptions: NavOptions? = null) {
    this.navigate(signupRoute, navOptions)
}

internal fun NavGraphBuilder.signupScreen() {
    composable(signupRoute) {
        SignupScreen()
    }
}