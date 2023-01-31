package com.silverbullet.mivu.core.data.preferences

import android.content.SharedPreferences
import com.silverbullet.mivu.core.domain.model.UserPref
import com.silverbullet.mivu.core.domain.preferences.Preferences

class AndroidPreferences(private val sharedPref: SharedPreferences) : Preferences {

    override fun getUserPref(): UserPref {
        val showAdultContent = sharedPref.getBoolean(Preferences.KEY_SHOW_ADULT_CONTENT, false)
        return UserPref(
            showAdultContent = showAdultContent
        )
    }

    override fun setShowAdultContent(value: Boolean) {
        sharedPref
            .edit()
            .putBoolean(Preferences.KEY_SHOW_ADULT_CONTENT, value)
            .apply()
    }
}