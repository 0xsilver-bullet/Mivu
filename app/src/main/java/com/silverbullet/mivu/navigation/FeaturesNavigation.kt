package com.silverbullet.mivu.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.silverbullet.core.ui.Dark
import com.silverbullet.feature.favorites.navigation.favoritesScreen
import com.silverbullet.feature.favorites.navigation.navigateToFavoritesScreen
import com.silverbullet.feature.home.navigation.homeRoute
import com.silverbullet.feature.home.navigation.homeScreen
import com.silverbullet.feature.home.navigation.navigateToHomeScreen
import com.silverbullet.feature.moviedetails.navigation.movieDetailsScreen
import com.silverbullet.feature.moviedetails.navigation.navigateToMovieDetailsScreen
import com.silverbullet.feature.profile.navigation.editProfileScreen
import com.silverbullet.feature.profile.navigation.navigateToEditProfileScreen
import com.silverbullet.feature.profile.navigation.navigateToProfileScreen
import com.silverbullet.feature.profile.navigation.profileGraph
import com.silverbullet.feature.search.navigation.navigateToSearchScreen
import com.silverbullet.feature.search.navigation.searchScreen
import com.silverbullet.mivu.navigation.components.MivuBottomBar
import com.silverbullet.mivu.navigation.utils.TopLevelDestination
import timber.log.Timber

const val mainGraphRoute = "main_graph_route"

fun NavController.navigateToMainFeaturesGraph() {
    val navOptions = navOptions { popUpTo(0) }
    this.navigate(mainGraphRoute, navOptions)
}

@ExperimentalAnimationApi
fun NavGraphBuilder.featuresGraph() {
    composable(mainGraphRoute) {
        MainFeatures()
    }
}

@Composable
@ExperimentalAnimationApi
private fun MainFeatures() {

    val navController = rememberNavController()
    val currentNavBackStack = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            MivuBottomBar(
                isVisible = currentNavBackStack.value?.destination.isAnyTopLevelDestination(),
                currentDestination = currentNavBackStack.value?.destination,
                destinations = TopLevelDestination.values().toList(),
                onNavigateToDestination = { destination ->
                    val topLevelNavOptions = navOptions {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    when (destination) {
                        TopLevelDestination.HOME -> navController
                            .navigateToHomeScreen(topLevelNavOptions)
                        TopLevelDestination.SEARCH -> navController
                            .navigateToSearchScreen(topLevelNavOptions)
                        TopLevelDestination.FAVORITES -> navController
                            .navigateToFavoritesScreen(topLevelNavOptions)
                        TopLevelDestination.PROFILE -> navController
                            .navigateToProfileScreen(topLevelNavOptions)
                    }
                }
            )
        }
    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Dark)
        ) {

            NavHost(navController = navController, startDestination = homeRoute) {

                homeScreen(
                    onFavoritesClick = { navController.navigateToFavoritesScreen() },
                    onMovieClick = { id, name ->
                        navController.navigateToMovieDetailsScreen(id, name)
                    }
                )
                searchScreen()
                favoritesScreen()
                profileGraph(
                    onEditProfile = { navController.navigateToEditProfileScreen() },
                    nestedGraphs = {
                        editProfileScreen()
                    }
                )
                movieDetailsScreen(navigateBack = navController::navigateUp)
            }
        }
    }
}

private fun NavDestination?.isAnyTopLevelDestination(): Boolean {
    return this?.hierarchy?.any { dest ->
        Timber.d(dest.route)
        TopLevelDestination.values()
            .any { topLevelDest -> dest.route?.contains(topLevelDest.name,ignoreCase = true) ?: false }
    } ?: false
}