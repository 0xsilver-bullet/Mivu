package com.silverbullet.mivu.navigation

sealed class Screen(val route: String){

    /**
     * Screen That contains option to login and signup
     */
    object StartScreen: Screen("start-screen")

    object LoginScreen: Screen("login-screen")

    object SignupScreen: Screen("signup-screen")

    object ResetPasswordScreen: Screen("reset-password-screen")

    /**
     * User enters the code sent by email to ensure account ownership
     */
    object VerifyAccountScreen: Screen("verify-account-screen")

    object CreateNewPasswordScreen: Screen("new-password-screen")

    object HomeScreen: Screen("home-screen")

    object SearchScreen: Screen("search-screen")

    object FavoritesScreen: Screen("favorites-screen")

    object ProfileScreen: Screen("profile-screen")

    object MovieDetailsScreen: Screen("movie-details")

}
