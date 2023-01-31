package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing

@Composable
fun EditableUserFields(
    modifier: Modifier = Modifier,
    onUsernameChanged: (String) -> Unit = {},
    onEmailChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
    username: String,
    email: String,
    password: String
) {
    Column(
        modifier,
        verticalArrangement = Arrangement
            .spacedBy(LocalSpacing.current.largeSpace)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChanged,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChanged,
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChanged,
            modifier = Modifier.fillMaxWidth()
        )
    }
}