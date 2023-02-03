package com.silverbullet.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.profile.EditProfileScreen

const val editProfileRoute = "edit_profile_route"

fun NavController.navigateToEditProfileScreen(navOptions: NavOptions? = null) {
    this.navigate(editProfileRoute, navOptions)
}

fun NavGraphBuilder.editProfileScreen() {
    composable(editProfileRoute) {
        EditProfileScreen()
    }
}