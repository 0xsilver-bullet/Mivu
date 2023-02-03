package com.silverbullet.feature.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.auth.CreateNewPasswordScreen

internal const val createNewPasswordRoute = "create-new-password-route"

internal fun NavController.navigateToCreateNewPasswordScreen(navOptions: NavOptions? = null) {
    this.navigate(createNewPasswordRoute, navOptions)
}

internal fun NavGraphBuilder.createNewPasswordScreen() {
    composable(createNewPasswordRoute) {
        CreateNewPasswordScreen()
    }
}