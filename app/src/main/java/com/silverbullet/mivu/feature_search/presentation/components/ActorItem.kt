package com.silverbullet.mivu.feature_search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.presentation.ui.theme.LargeSpace
import com.silverbullet.mivu.feature_search.domain.model.Actor

@Composable
fun ActorItem(
    modifier: Modifier = Modifier,
    imageSize: Dp = 64.dp,
    actor: Actor,
    onClick: (Actor) -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(Color.Red)
                .clickable { onClick(actor) }
        )
        Spacer(modifier = Modifier.height(LargeSpace))
        Text(
            text = actor.name,
            style = MaterialTheme.typography.h6,
            color = Color.White,
            modifier = Modifier.clickable { onClick(actor) }
        )
    }
}