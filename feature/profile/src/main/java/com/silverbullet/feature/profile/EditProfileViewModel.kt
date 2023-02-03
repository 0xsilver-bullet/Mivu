package com.silverbullet.feature.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableStateFlow<com.silverbullet.core.model.User?>(null)
    val user = _user.asStateFlow()

    private val _state = MutableStateFlow(EditProfileScreenState())
    val state = _state.asStateFlow()

    init {
        _user.value = com.silverbullet.core.model.User(
            name = "Aly",
            email = "asecure05@gmail.co",
            ""
        )
        _state.value = EditProfileScreenState.fromUser(_user.value!!)
    }

    fun onEvent(event: EditProfileScreenEvent) {
        when (event) {
            is EditProfileScreenEvent.UserNameChanged -> _state.value =
                _state.value.copy(username = event.username)
            is EditProfileScreenEvent.UserEmailChanged ->
                _state.value = _state.value.copy(email = event.email)
            is EditProfileScreenEvent.UserPasswordChanged ->
                _state.value = _state.value.copy(password = event.password)
            EditProfileScreenEvent.EditProfileImage -> editProfilePicture()
            EditProfileScreenEvent.SaveButtonClicked -> updateProfileInfo()
        }
    }

    private fun editProfilePicture(){
        // TODO: Need to be implemented
    }

    private fun updateProfileInfo(){
        // TODO: Need to be implemented
    }
}