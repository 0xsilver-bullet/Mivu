package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.LoginScreen

internal const val loginRoute = "login_route"

internal fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null){
    this.navigate(loginRoute,navOptions)
}

internal fun NavGraphBuilder.loginScreen(
    onLoggedIn: () -> Unit,
    onForgotPassword: () -> Unit,
){
    composable(loginRoute){
        LoginScreen(
            onLoggedIn = onLoggedIn,
            onForgotPassword = onForgotPassword
        )
    }
}