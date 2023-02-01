package com.silverbullet.mivu.feature_profile.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.R
import com.silverbullet.mivu.feature_profile.presentation.components.ProfileInfo
import com.silverbullet.mivu.feature_profile.presentation.components.SettingItem
import com.silverbullet.mivu.feature_profile.presentation.components.SettingsContainer
import com.silverbullet.mivu.feature_profile.presentation.components.UserPrefToggler
import com.silverbullet.mivu.navigation.utils.Screen

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navCallback: (Screen) -> Unit
) {

    val userState = viewModel.userState.collectAsState()
    val userPrefs = viewModel.userPrefs.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = LocalSpacing.current.smallSpace,
                start = LocalSpacing.current.largeSpace,
                end = LocalSpacing.current.largeSpace
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.profile),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        userState.value?.let { user ->
            ProfileInfo(
                user = user,
                modifier = Modifier.fillMaxWidth(),
                actionCallback = {
                    navCallback(Screen.EditProfileScreen)
                }
            )
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        SettingsContainer(
            titleRes = R.string.account,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SettingItem(titleRes = R.string.change_password, iconRes = R.drawable.ic_lock)

        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        SettingsContainer(
            titleRes = R.string.general,
            modifier = Modifier.fillMaxWidth()
        ) {
            UserPrefToggler(
                titleRes = R.string.show_adult_content,
                state = userPrefs.value.showAdultContent,
                onToggle = viewModel::toggleShowAdultContent
            )
        }
    }
}

