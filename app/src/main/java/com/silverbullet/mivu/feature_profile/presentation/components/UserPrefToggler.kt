package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun UserPrefToggler(
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