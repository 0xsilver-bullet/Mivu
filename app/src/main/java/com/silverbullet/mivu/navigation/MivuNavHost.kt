package com.silverbullet.mivu.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MivuNavHost(navHostController: NavHostController, startDestination: String) {

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {

        composable(Screen.StartScreen.route) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = "Start Destination", style = MaterialTheme.typography.h1)
            }
        }
    }
}