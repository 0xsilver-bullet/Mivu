package com.silverbullet.feature.profile

sealed class EditProfileScreenEvent{

    data class UserNameChanged(val username: String): EditProfileScreenEvent()

    data class UserEmailChanged(val email: String): EditProfileScreenEvent()

    data class UserPasswordChanged(val password: String): EditProfileScreenEvent()

    object SaveButtonClicked: EditProfileScreenEvent()

    object EditProfileImage: EditProfileScreenEvent()
}
