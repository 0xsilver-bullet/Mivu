package com.silverbullet.core.data.repository

import android.content.SharedPreferences
import com.silverbullet.core.data.Preferences
import com.silverbullet.core.model.UserPref
import javax.inject.Inject

class AndroidPreferences @Inject constructor(
    private val sharedPref: SharedPreferences
) :
    Preferences {

    override fun getUserPref(): UserPref {
        val showAdultContent = sharedPref.getBoolean(
            Preferences.KEY_SHOW_ADULT_CONTENT,
            false
        )
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