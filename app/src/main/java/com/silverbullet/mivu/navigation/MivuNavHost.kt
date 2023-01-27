package com.silverbullet.mivu.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silverbullet.mivu.core.presentation.components.MivuTopBar
import com.silverbullet.mivu.feature_auth.presentation.*

@Composable
fun MivuNavHost(navHostController: NavHostController, startDestination: String) {

    val currentNavBackStack = navHostController.currentBackStackEntryAsState()

    val currentTopBarConfig by remember {
        derivedStateOf {
            val route = currentNavBackStack.value?.destination?.route
            Screen.getTopBarConfigFromRoute(route ?: "")
        }
    }

    Scaffold(
        topBar = {
            MivuTopBar(
                navController = navHostController,
                topBarConfig = currentTopBarConfig
            )
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavHost(
                navController = navHostController,
                startDestination = startDestination
            ) {

                composable(Screen.StartScreen.route) {
                    StartScreen(
                        navCallback = { screen ->
                            navHostController.navigate(screen.route)
                        }
                    )
                }

                composable(Screen.LoginScreen.route) {
                    LoginScreen(
                        navCallback = { screen ->
                            navHostController.navigate(screen.route)
                        }
                    )
                }

                composable(Screen.SignupScreen.route) {
                    SignupScreen()
                }

                composable(Screen.ResetPasswordScreen.route) {
                    ResetPasswordScreen(
                        navCallback = { screen ->
                            navHostController.navigate(screen.route)
                        }
                    )
                }

                composable(Screen.VerifyAccountScreen.route) {
                    VerifyAccountScreen(
                        navCallback = { screen ->
                            navHostController.navigate(screen.route)
                        }
                    )
                }

                composable(Screen.CreateNewPasswordScreen.route) {
                    CreateNewPasswordScreen()
                }

            }
        }

    }
}