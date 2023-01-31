package com.silverbullet.mivu.feature_profile.presentation

import androidx.lifecycle.ViewModel
import com.silverbullet.mivu.core.domain.model.User
import com.silverbullet.mivu.core.domain.model.UserPref
import com.silverbullet.mivu.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val userState = _user.asStateFlow()

    private val _userPrefs = MutableStateFlow(UserPref(showAdultContent = false))
    val userPrefs = _userPrefs.asStateFlow()

    init {
        _user.value = User(
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