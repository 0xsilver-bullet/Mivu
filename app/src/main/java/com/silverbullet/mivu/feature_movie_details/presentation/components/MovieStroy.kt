package com.silverbullet.mivu.feature_movie_details.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.TextWhiteGrey

@Composable
fun MovieStory(
    modifier: Modifier = Modifier,
    story: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.smallSpace)
    ) {
        Text(
            text = stringResource(id = R.string.story_line),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Text(
            text = story,
            style = MaterialTheme.typography.h5,
            color = TextWhiteGrey,
            lineHeight = 22.sp
        )
    }
}