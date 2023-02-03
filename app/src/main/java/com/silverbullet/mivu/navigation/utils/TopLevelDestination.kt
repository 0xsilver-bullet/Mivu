package com.silverbullet.mivu.navigation.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.silverbullet.mivu.R

enum class TopLevelDestination(
    @StringRes val titleId: Int,
    @DrawableRes val iconId: Int
){

    HOME(
        titleId = R.string.home,
        iconId = R.drawable.ic_home
    ),

    SEARCH(
        titleId = R.string.search,
        iconId = R.drawable.ic_search
    ),

    FAVORITES(
        titleId = R.string.favorites,
        iconId = R.drawable.ic_favorite
    ),

    PROFILE(
        titleId = R.string.profile,
        iconId = R.drawable.ic_person
    )
}