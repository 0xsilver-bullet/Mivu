package com.silverbullet.mivu.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.core.domain.model.MovieInfo
import com.silverbullet.mivu.core.presentation.ui.theme.*
import kotlin.random.Random

@Composable
fun MovieInfoItem(
    modifier: Modifier = Modifier,
    movieInfo: MovieInfo,
    itemWidth: Dp = 135.dp,
    itemHeight: Dp = 210.dp,
    onClick: (MovieInfo) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .width(itemWidth)
            .height(itemHeight)
            .background(Soft)
            .clickable { onClick(movieInfo) }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .background(Color(Random.nextLong(0, 0xFFFFFFFF)))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(LocalSpacing.current.smallSpace),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = movieInfo.title,
                style = MaterialTheme.typography.h5,
                color = Color.White,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = movieInfo.category.name,
                fontSize = 10.sp,
                fontFamily = Montserrat,
                color = TextGrey
            )
        }
        RatingItem(
            rating = movieInfo.rating,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(LocalSpacing.current.smallSpace)
        )
    }
}