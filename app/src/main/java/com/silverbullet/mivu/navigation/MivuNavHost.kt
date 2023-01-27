package com.silverbullet.mivu.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.silverbullet.mivu.core.presentation.components.MivuTopBar
import com.silverbullet.mivu.feature_auth.presentation.StartScreen

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
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "Login Screen",
                            modifier = Modifier.align(Alignment.Center),
                            style = MaterialTheme.typography.h1
                        )
                    }
                }

            }
        }

    }
}