package com.silverbullet.feature.profile

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core.ui.BlueAccent
import com.silverbullet.core.ui.LocalSpacing
import com.silverbullet.core.ui.Soft
import com.silverbullet.core.ui.TextGrey

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    onEditProfile: () -> Unit
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
                actionCallback = { onEditProfile() }
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

@Composable
private fun ProfileInfo(
    modifier: Modifier = Modifier,
    actionCallback: () -> Unit = {},
    iconSize: Dp = 54.dp,
    user: com.silverbullet.core.model.User,
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Soft, shape = RoundedCornerShape(16.dp))
            .padding(LocalSpacing.current.mediumSpace)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(iconSize)
                    .clip(CircleShape)
                    .background(Color.Red)
            )
            Spacer(modifier = Modifier.width(LocalSpacing.current.mediumSpace))
            Column(horizontalAlignment = Alignment.Start) {
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
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = stringResource(id = R.string.edit_profile_button),
                tint = BlueAccent,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { actionCallback() }
            )
        }
    }
}

@Composable
private fun UserPrefToggler(
    @StringRes titleRes: Int,
    state: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            stringResource(id = titleRes),
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(checked = state, onCheckedChange = { onToggle(it) })
    }
}

@Composable
private fun SettingsContainer(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Soft, shape = RoundedCornerShape(16.dp))
            .padding(
                horizontal = LocalSpacing.current.mediumSpace,
                vertical = LocalSpacing.current.largeSpace
            )
    ) {
        Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text(
                text = stringResource(id = titleRes),
                style = MaterialTheme.typography.h3,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
            content()
        }
    }
}

@Composable
private fun SettingItem(
    @StringRes titleRes: Int,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(vertical = LocalSpacing.current.mediumSpace),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Soft),
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = painterResource(id = iconRes), contentDescription = null,tint= TextGrey)
        }
        Spacer(modifier = Modifier.width(LocalSpacing.current.largeSpace))
        Text(
            text = stringResource(id = titleRes),
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = null,
            tint = BlueAccent
        )
    }
}
