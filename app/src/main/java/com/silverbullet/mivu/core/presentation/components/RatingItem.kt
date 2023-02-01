package com.silverbullet.mivu.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.Orange

@Composable
fun RatingItem(
    modifier: Modifier = Modifier,
    rating: Float
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xA3252836))
            .padding(horizontal = LocalSpacing.current.smallSpace, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_start),
                contentDescription = null,
                tint = Orange
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = rating.toString(),
                style = MaterialTheme.typography.h6,
                color = Orange
            )
        }
    }
}