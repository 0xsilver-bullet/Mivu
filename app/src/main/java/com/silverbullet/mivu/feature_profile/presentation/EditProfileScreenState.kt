package com.silverbullet.mivu.feature_profile.presentation

import com.silverbullet.mivu.core.domain.model.User

data class EditProfileScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = ""
){

    companion object{

        fun fromUser(user: User): EditProfileScreenState{
            return EditProfileScreenState(
                username =user.name,
                email = user.email,
                password = ""
            )
        }
    }
}
