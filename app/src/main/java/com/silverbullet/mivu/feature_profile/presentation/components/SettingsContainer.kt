package com.silverbullet.mivu.feature_profile.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing
import com.silverbullet.mivu.core.presentation.ui.theme.Soft

@Composable
fun SettingsContainer(
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