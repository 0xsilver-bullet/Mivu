package com.silverbullet.mivu.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.domain.model.CategoryItem
import com.silverbullet.mivu.core.presentation.ui.theme.*

@Composable
fun CategoryCard(
    item: CategoryItem,
    selected: Boolean,
    onClick: (CategoryItem) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.h6,
    verticalPadding: Dp = LocalSpacing.current.smallSpace,
    horizontalPadding: Dp = 32.dp
) {
    val boxModifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(if(selected) Soft else Dark)
        .clickable {
            if (!selected) {
                onClick(item)
            }
        }
        .padding(horizontal = horizontalPadding, vertical = verticalPadding)

    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
        Text(text = item.name, style = textStyle, color = if (selected) BlueAccent else Color.White)
    }
}