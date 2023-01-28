package com.silverbullet.mivu.navigation.utils

import com.silverbullet.mivu.R
import com.silverbullet.mivu.navigation.model.TopBarConfig

sealed class Screen(val route: String, val topBarConfig: TopBarConfig) {

    /**
     * Screen That contains option to login and signup
     */
    object StartScreen : Screen("start-screen", TopBarConfig())

    object LoginScreen : Screen(
        "login-screen",
        TopBarConfig(
            visible = true,
            iconRes = R.drawable.ic_back,
            title = R.string.login,
            iconCallback = { navController ->
                navController.navigateUp()
            }
        )
    )

    object SignupScreen : Screen(
        "signup-screen",
        TopBarConfig(
            visible = true,
            iconRes = R.drawable.ic_back,
            title = R.string.signup,
            iconCallback = { navController -> navController.navigateUp() }
        )
    )

    object ResetPasswordScreen : Screen(
        "reset-password-screen",
        TopBarConfig(
            visible = true,
            iconRes = R.drawable.ic_back,
            title = null,
            iconCallback = { navController -> navController.navigateUp() }
        )
    )

    /**
     * User enters the code sent by email to ensure account ownership
     */
    object VerifyAccountScreen : Screen(
        "verify-account-screen",
        TopBarConfig(
            visible = true,
            iconRes = R.drawable.ic_back,
            title = null,
            iconCallback = { navController -> navController.navigateUp() }
        )
    )

    object CreateNewPasswordScreen : Screen(
        "new-password-screen",
        TopBarConfig(
            visible = true,
            iconRes = R.drawable.ic_back,
            title = null,
            iconCallback = { navController -> navController.navigateUp() }
        )
    )

    object HomeScreen : Screen("home-screen", TopBarConfig())

    object SearchScreen : Screen("search-screen", TopBarConfig())

    object FavoritesScreen : Screen("favorites-screen", TopBarConfig())

    object ProfileScreen : Screen("profile-screen", TopBarConfig())

    object MovieDetailsScreen : Screen("movie-details", TopBarConfig())

    companion object {
        fun getTopBarConfigFromRoute(route: String): TopBarConfig = when (route) {
            StartScreen.route -> StartScreen.topBarConfig
            LoginScreen.route -> LoginScreen.topBarConfig
            SignupScreen.route -> SignupScreen.topBarConfig
            ResetPasswordScreen.route -> ResetPasswordScreen.topBarConfig
            VerifyAccountScreen.route -> VerifyAccountScreen.topBarConfig
            CreateNewPasswordScreen.route -> CreateNewPasswordScreen.topBarConfig
            SearchScreen.route -> SearchScreen.topBarConfig
            FavoritesScreen.route -> FavoritesScreen.topBarConfig
            ProfileScreen.route -> ProfileScreen.topBarConfig
            MovieDetailsScreen.route -> MovieDetailsScreen.topBarConfig
            else -> TopBarConfig()
        }
    }

}
