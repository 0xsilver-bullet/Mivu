package com.silverbullet.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core.ui.*

@Composable
internal fun EditProfileScreen(viewModel: EditProfileViewModel = hiltViewModel()) {

    val user = viewModel.user.collectAsState()
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace),
        horizontalAlignment = CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = stringResource(id = R.string.edit_profile),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        user.value?.let { user ->
            ProfileInfoSection(
                user = user,
                modifier = Modifier.align(CenterHorizontally),
                editProfilePictureCallback = {
                    viewModel.onEvent(EditProfileScreenEvent.EditProfileImage)
                }
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        EditableUserFields(
            username = state.value.username,
            email = state.value.email,
            password = state.value.password,
            onUsernameChanged = { username ->
                viewModel.onEvent(
                    EditProfileScreenEvent.UserNameChanged(username)
                )
            },
            onEmailChanged = { email ->
                viewModel.onEvent(
                    EditProfileScreenEvent.UserEmailChanged(email)
                )
            },
            onPasswordChanged = { password ->
                viewModel.onEvent(
                    EditProfileScreenEvent.UserPasswordChanged(password)
                )
            }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = { viewModel.onEvent(EditProfileScreenEvent.SaveButtonClicked) },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = BlueAccent)
        ) {
            Text(
                text = stringResource(id = R.string.save_chagnes),
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
        }
    }
}

@Composable
private fun ProfileInfoSection(
    modifier: Modifier = Modifier,
    profilePicSize: Dp = 72.dp,
    user: com.silverbullet.core.model.User,
    editProfilePictureCallback: () -> Unit = {}
) {
    Column(horizontalAlignment = CenterHorizontally, modifier = modifier) {
        Box(contentAlignment = Center) {
            Box(
                modifier = Modifier
                    .size(profilePicSize)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Box(
                modifier = Modifier
                    .offset(profilePicSize / 3f, profilePicSize / 3f)
                    .size(32.dp)
                    .clip(CircleShape)
                    .clickable { editProfilePictureCallback() }
                    .background(Soft),
                contentAlignment = Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_edit_pen),
                    contentDescription = null,
                    tint = BlueAccent
                )
            }
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        Text(
            text = user.name,
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Text(
            text = user.email,
            style = MaterialTheme.typography.h5,
            color = TextGrey
        )
    }
}

@Composable
private fun EditableUserFields(
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
            hintText = stringResource(id = R.string.password),
            singleLine = true,
            hideInput = true
        )
    }
}