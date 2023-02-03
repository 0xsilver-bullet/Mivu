package com.silverbullet.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.profile.ProfileScreen

const val profileRoute = "profile_route"

fun NavController.navigateToProfileRoute(navOptions: NavOptions? = null) {
    this.navigate(profileRoute, navOptions)
}

fun NavGraphBuilder.profileScreen(
    onEditProfile: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    composable(profileRoute) {
        ProfileScreen(onEditProfile = onEditProfile)
    }
    nestedGraphs()
}