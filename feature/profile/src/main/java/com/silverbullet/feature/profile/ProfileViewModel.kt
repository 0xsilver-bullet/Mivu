package com.silverbullet.feature.profile

import androidx.lifecycle.ViewModel
import com.silverbullet.core.data.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    private val _user = MutableStateFlow<com.silverbullet.core.model.User?>(null)
    val userState = _user.asStateFlow()

    private val _userPrefs = MutableStateFlow(com.silverbullet.core.model.UserPref(showAdultContent = false))
    val userPrefs = _userPrefs.asStateFlow()

    init {
        _user.value = com.silverbullet.core.model.User(
            "Aly",
            "asecure05@gmail.com",
            ""
        )
        initUserPrefs()
    }

    fun toggleShowAdultContent(value: Boolean){
        preferences.setShowAdultContent(value)
        initUserPrefs()
    }

    private fun initUserPrefs() {
        val currentUserPrefs = preferences.getUserPref()
        if (currentUserPrefs != _userPrefs.value) {
            _userPrefs.value = currentUserPrefs
        }
    }
}