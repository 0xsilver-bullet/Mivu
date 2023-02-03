package com.silverbullet.core.data

import com.silverbullet.core.model.UserPref


interface Preferences {

    fun getUserPref(): UserPref

    fun setShowAdultContent(value: Boolean)

    companion object {

        const val KEY_SHOW_ADULT_CONTENT = "show_adult_content"
    }
}