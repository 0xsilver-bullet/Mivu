package com.silverbullet.mivu.feature_movie_details.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BasicInfoItem(
    color: Color = Color.Gray,
    @DrawableRes iconRes: Int,
    data: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = color
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = data,
            style = MaterialTheme.typography.h6,
            color = color
        )
    }
}