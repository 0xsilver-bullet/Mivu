package com.silverbullet.mivu

import androidx.lifecycle.ViewModel
import com.silverbullet.core.data.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {
    fun isAuthenticationRequired(): Boolean{
        return !preferences.isLoggedIn()
    }

}