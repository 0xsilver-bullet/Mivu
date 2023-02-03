package com.silverbullet.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.home.HomeScreen

const val homeRoute = "home_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    onFavoritesClick: () -> Unit,
    onMovieClick: (String, String) -> Unit
) {
    composable(homeRoute) {
        HomeScreen(
            onFavoritesClick = onFavoritesClick,
            onMovieClick = onMovieClick
        )
    }
}