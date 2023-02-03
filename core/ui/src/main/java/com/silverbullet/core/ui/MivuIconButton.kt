package com.silverbullet.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MivuIconButton(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    callback: () -> Unit = {},
    @DrawableRes iconRes: Int
) {
    Box(
        modifier = modifier
            .size(32.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF252836))
            .clickable {
                callback()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = tint
        )
    }
}