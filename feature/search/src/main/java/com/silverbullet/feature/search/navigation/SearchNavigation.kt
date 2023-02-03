package com.silverbullet.feature.search.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.search.SearchScreen

const val searchRoute = "search_route"

fun NavController.navigateToSearchScreen(navOptions: NavOptions? = null) {
    this.navigate(searchRoute, navOptions)
}

@ExperimentalAnimationApi
fun NavGraphBuilder.searchScreen() {
    composable(searchRoute) {
        SearchScreen()
    }
}