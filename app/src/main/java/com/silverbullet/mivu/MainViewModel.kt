package com.silverbullet.mivu

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.silverbullet.core.data.utils.SharedPrefKeys
import com.silverbullet.mivu.navigation.utils.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPref: SharedPreferences
) : ViewModel() {

    private val _startDestination = MutableStateFlow<String?>(null)
    val startDestination = _startDestination.asStateFlow()

    init {
        setStartDestination()
    }

    private fun setStartDestination() {
        val isLoggedIn = sharedPref.getBoolean(SharedPrefKeys.IS_LOGGED_IN, false)
        if (isLoggedIn) {
            _startDestination.value = Screen.HomeScreen.route
        } else {
            _startDestination.value = Screen.StartScreen.route
        }
    }
}