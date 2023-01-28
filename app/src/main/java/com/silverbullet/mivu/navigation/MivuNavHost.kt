package com.silverbullet.mivu.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silverbullet.mivu.feature_auth.presentation.*
import com.silverbullet.mivu.feature_favorites.presentation.FavoritesScreen
import com.silverbullet.mivu.feature_home.presentation.HomeScreen
import com.silverbullet.mivu.feature_profile.presentation.ProfileScreen
import com.silverbullet.mivu.feature_search.presentation.SearchScreen
import com.silverbullet.mivu.navigation.components.MivuBottomBar
import com.silverbullet.mivu.navigation.components.MivuTopBar
import com.silverbullet.mivu.navigation.utils.NavigationConstants
import com.silverbullet.mivu.navigation.utils.Screen

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
                setupRoutes(navController)
            }
        }
    }
}

fun NavGraphBuilder.setupRoutes(navController: NavController){
    composable(Screen.StartScreen.route) {
        StartScreen(
            navCallback = { screen ->
                navController.navigate(screen.route)
            }
        )
    }

    composable(Screen.LoginScreen.route) {
        LoginScreen(
            navCallback = { screen ->
                navController.navigate(screen.route)
            }
        )
    }

    composable(Screen.SignupScreen.route) {
        SignupScreen()
    }

    composable(Screen.ResetPasswordScreen.route) {
        ResetPasswordScreen(
            navCallback = { screen ->
                navController.navigate(screen.route)
            }
        )
    }

    composable(Screen.VerifyAccountScreen.route) {
        VerifyAccountScreen(
            navCallback = { screen ->
                navController.navigate(screen.route)
            }
        )
    }

    composable(Screen.CreateNewPasswordScreen.route) {
        CreateNewPasswordScreen()
    }

    composable(Screen.HomeScreen.route) {
        HomeScreen()
    }

    composable(Screen.SearchScreen.route){
        SearchScreen()
    }

    composable(Screen.FavoritesScreen.route){
        FavoritesScreen()
    }

    composable(Screen.ProfileScreen.route){
        ProfileScreen()
    }
}