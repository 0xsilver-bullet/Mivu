package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.core_ui.MivuTextField
import com.silverbullet.mivu.R

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

        MivuTextField(
            value = username,
            onValueChanged = onUsernameChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.full_name),
            singleLine = true
        )
        MivuTextField(
            value = email,
            onValueChanged = onEmailChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.email),
            singleLine = true
        )
        MivuTextField(
            value = password,
            onValueChanged = onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.h5.copy(Color.Gray),
            hintStyle = MaterialTheme.typography.h6.copy(color = Color.White),
            hintText = stringResource(id = R.string.full_name),
            singleLine = true,
            hideInput = true
        )
    }
}