package com.silverbullet.mivu.feature_movie_details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.presentation.ui.theme.TextDarkGrey

@Composable
fun VerticalSeparator() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(16.dp)
            .background(TextDarkGrey)
    )
}