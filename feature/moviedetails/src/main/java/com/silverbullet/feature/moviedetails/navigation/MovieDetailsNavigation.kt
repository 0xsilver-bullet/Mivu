package com.silverbullet.feature.moviedetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.silverbullet.feature.moviedetails.MovieDetailsScreen

const val movieDetailsRoute = "movie_details_route"

fun NavController.navigateToMovieDetailsScreen(
    id: String,
    title: String,
    navOptions: NavOptions? = null
) {
    this.navigate(movieDetailsRoute, navOptions)
}

fun NavGraphBuilder.movieDetailsScreen(
    navigateBack: () -> Unit
) {
    composable(movieDetailsRoute) {
        MovieDetailsScreen(navigateBack = navigateBack)
    }
}