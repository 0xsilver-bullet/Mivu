package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.domain.model.User
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.R

@Composable
fun ProfileInfo(
    modifier: Modifier = Modifier,
    actionCallback: () -> Unit = {},
    iconSize: Dp = 54.dp,
    user: User,
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