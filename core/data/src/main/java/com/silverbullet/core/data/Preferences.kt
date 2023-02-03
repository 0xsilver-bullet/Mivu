package com.silverbullet.core.data

import com.silverbullet.core.model.UserPref


interface Preferences {

    fun getUserPref(): UserPref

    fun setShowAdultContent(value: Boolean)

    fun isLoggedIn(): Boolean

    companion object {

        const val SHARED_PREF_NAME = "MivuSharedPref"

        const val KEY_SHOW_ADULT_CONTENT = "show_adult_content"

        const val KEY_IS_LOGGED_IN = "is_logged_in"
    }
}