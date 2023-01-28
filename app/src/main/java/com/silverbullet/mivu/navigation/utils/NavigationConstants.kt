package com.silverbullet.mivu.navigation.utils

import com.silverbullet.mivu.R
import com.silverbullet.mivu.navigation.model.BottomNavItemInfo

object NavigationConstants {

    val routesWithBottomNavBar = listOf(
        Screen.HomeScreen.route,
        Screen.SearchScreen.route,
        Screen.FavoritesScreen.route,
        Screen.ProfileScreen.route
    )

    val bottomNavItems = listOf(
        BottomNavItemInfo(
            title = R.string.home,
            route = Screen.HomeScreen.route,
            icon = R.drawable.ic_home
        ),
        BottomNavItemInfo(
            title = R.string.search,
            route = Screen.SearchScreen.route,
            icon = R.drawable.ic_search
        ),
        BottomNavItemInfo(
            title = R.string.favorites,
            route = Screen.FavoritesScreen.route,
            icon = R.drawable.ic_favorite
        ),
        BottomNavItemInfo(
            title = R.string.profile,
            route = Screen.ProfileScreen.route,
            icon = R.drawable.ic_person
        )
    )

}