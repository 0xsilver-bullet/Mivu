package com.silverbullet.feature.profile

data class EditProfileScreenState(
    val username: String = "",
    val email: String = "",
    val password: String = ""
){

    companion object{

        fun fromUser(user: com.silverbullet.core.model.User): EditProfileScreenState {
            return EditProfileScreenState(
                username =user.name,
                email = user.email,
                password = ""
            )
        }
    }
}
