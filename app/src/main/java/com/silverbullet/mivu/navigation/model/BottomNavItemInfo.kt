package com.silverbullet.mivu.navigation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItemInfo(
    @StringRes val title: Int,
    val route: String,
    @DrawableRes val icon: Int
)