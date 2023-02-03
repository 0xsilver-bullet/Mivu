package com.silverbullet.mivu.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silverbullet.feature.auth.navigation.*
import com.silverbullet.feature.favorites.navigation.favoritesScreen
import com.silverbullet.feature.favorites.navigation.navigateToFavoritesScreen
import com.silverbullet.feature.home.navigation.homeScreen
import com.silverbullet.feature.home.navigation.navigateToHomeScreen
import com.silverbullet.feature.search.navigation.searchScreen
import com.silverbullet.feature.moviedetails.navigation.movieDetailsScreen
import com.silverbullet.feature.moviedetails.navigation.navigateToMovieDetailsScreen
import com.silverbullet.feature.profile.navigation.editProfileScreen
import com.silverbullet.feature.profile.navigation.navigateToEditProfileScreen
import com.silverbullet.feature.profile.navigation.profileScreen
import com.silverbullet.mivu.navigation.components.MivuBottomBar
import com.silverbullet.mivu.navigation.components.MivuTopBar
import com.silverbullet.mivu.navigation.utils.NavigationConstants
import com.silverbullet.mivu.navigation.utils.Screen

@ExperimentalAnimationApi
@Composable
fun MivuNavHost(navController: NavHostController, startDestination: String) {

    val currentNavBackStack = navController.currentBackStackEntryAsState()

    val currentTopBarConfig by remember {
        derivedStateOf {
            val route = currentNavBackStack.value?.destination?.route
            Screen.getTopBarConfigFromRoute(route ?: "")
        }
    }

    Scaffold(
        topBar = {
            MivuTopBar(
                navController = navController,
                topBarConfig = currentTopBarConfig
            )
        },
        bottomBar = {
            val currentRoute = currentNavBackStack.value?.destination?.route ?: ""
            MivuBottomBar(
                isVisible = NavigationConstants
                    .routesWithBottomNavBar.find { it == currentRoute } != null,
                defaultRoute = Screen.HomeScreen.route,
                currentRoute = currentRoute,
                navItems = NavigationConstants.bottomNavItems,
                navController = navController
            )
        }
    ) { paddingValues ->

        Surface(modifier = Modifier.padding(paddingValues)) {

            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                startScreen(
                    onLogin = { navController.navigateToLoginScreen() },
                    onSignup = { navController.navigateToSignupScreen() },
                    nestedGraphs = {
                        loginScreen(
                            onLoggedIn = { navController.navigateToHomeScreen() },
                            onForgotPassword = { navController.navigateToResetPasswordScreen() },
                            nestedGraphs = {
                                resetPasswordScreen(
                                    onVerify = { navController.navigateToVerifyAccountScreen() },
                                    nestedGraphs = {
                                        verifyAccountScreen(
                                            onVerified = { navController.navigateToCreateNewPasswordScreen() },
                                            nestedGraphs = {
                                                createNewPasswordScreen()
                                            }
                                        )
                                    }
                                )
                            }
                        )
                        signupScreen()
                    }
                )
                homeScreen(
                    onFavoritesClick = { navController.navigateToFavoritesScreen() },
                    onMovieClick = { id, name ->
                        navController.navigateToMovieDetailsScreen(id, name)
                    }
                )
                searchScreen()
                favoritesScreen()
                profileScreen(
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