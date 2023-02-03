package com.silverbullet.feature.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.favorites.FavoritesScreen

const val favoritesRoute = "favorites_route"

fun NavController.navigateToFavoritesScreen(navOptions: NavOptions? = null) {
    this.navigate(favoritesRoute, navOptions)
}

fun NavGraphBuilder.favoritesScreen() {
    composable(favoritesRoute) {
        FavoritesScreen()
    }
}