package com.silverbullet.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.silverbullet.feature.profile.ProfileScreen

private const val profileGraphRoute = "profile_graph"
const val profileRoute = "profile_route"

fun NavController.navigateToProfileScreen(navOptions: NavOptions? = null) {
    this.navigate(profileGraphRoute, navOptions)
}

fun NavGraphBuilder.profileGraph(
    onEditProfile: () -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        startDestination = profileRoute,
        route = profileGraphRoute
    ) {
        composable(profileRoute) {
            ProfileScreen(onEditProfile = onEditProfile)
        }
        nestedGraphs()
    }
}