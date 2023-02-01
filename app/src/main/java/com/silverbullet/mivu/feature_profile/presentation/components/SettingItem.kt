package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.BlueAccent
import com.silverbullet.mivu.core.presentation.ui.theme.Soft
import com.silverbullet.mivu.core.presentation.ui.theme.TextGrey

@Composable
fun SettingItem(
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