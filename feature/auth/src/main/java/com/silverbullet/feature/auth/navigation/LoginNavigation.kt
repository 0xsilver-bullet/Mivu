package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null){
    this.navigate(loginRoute,navOptions)
}

fun NavGraphBuilder.loginScreen(
    onLoggedIn: () -> Unit,
    onForgotPassword: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
){
    composable(loginRoute){
        LoginScreen(
            onLoggedIn = onLoggedIn,
            onForgotPassword = onForgotPassword
        )
    }
    nestedGraphs()
}