package com.silverbullet.mivu.navigation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavController

data class TopBarConfig(
    val visible: Boolean = false,
    @StringRes val title: Int? = null,
    @DrawableRes val iconRes: Int? = null,
    val iconCallback: ((NavController) -> Unit)? = null
)
