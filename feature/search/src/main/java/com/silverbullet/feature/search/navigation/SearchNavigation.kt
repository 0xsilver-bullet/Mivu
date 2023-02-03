package com.silverbullet.feature.search.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.silverbullet.feature.search.SearchScreen

const val searchRoute = "search_route"

fun NavController.navigateToSearchScreen(){
    this.navigate(searchRoute)
}

@ExperimentalAnimationApi
fun NavGraphBuilder.searchScreen(){
    composable(searchRoute){
        SearchScreen()
    }
}