package com.silverbullet.feature.auth.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.silverbullet.core.ui.Dark

const val authGraphRoute = "auth_graph_route"

@Composable
fun Authentication(
    onLogin: () -> Unit
) {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
    ) {

        NavHost(navController = navController, startDestination = startRoute) {
            startScreen(
                onLogin = navController::navigateToLoginScreen,
                onSignup = navController::navigateToSignupScreen
            )
            loginScreen(
                onLogin,
                onForgotPassword = navController::navigateToResetPasswordScreen
            )
            signupScreen()
            resetPasswordScreen(onVerify = navController::navigateToVerifyAccountScreen)
            verifyAccountScreen(onVerified = navController::navigateToCreateNewPasswordScreen)
            createNewPasswordScreen()
        }
    }
}

fun NavController.navigateToAuthenticationGraph() {
    val navOptions = navOptions {
        popUpTo(0)
    }
    this.navigate(authGraphRoute, navOptions)
}

fun NavGraphBuilder.authenticationGraph(
    onLogin: () -> Unit
) {
    composable(authGraphRoute) {
        Authentication(onLogin = onLogin)
    }
}