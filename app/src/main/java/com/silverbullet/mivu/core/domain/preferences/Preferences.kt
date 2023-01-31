package com.silverbullet.mivu.core.domain.preferences

import com.silverbullet.mivu.core.domain.model.UserPref

interface Preferences {

    fun getUserPref(): UserPref

    fun setShowAdultContent(value: Boolean)

    companion object{

        const val KEY_SHOW_ADULT_CONTENT = "show_adult_content"
    }
}