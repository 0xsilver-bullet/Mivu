package com.silverbullet.mivu.feature_favorites.presentation.components

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.silverbullet.mivu.core.domain.model.MovieInfo
import com.silverbullet.mivu.core.presentation.ui.theme.MediumSpace
import kotlin.random.Random
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.components.RatingItem
import com.silverbullet.mivu.core.presentation.ui.theme.PaddingSmall
import com.silverbullet.mivu.core.presentation.ui.theme.TextGrey

@Composable
fun DetailedMovieItem(
    modifier: Modifier = Modifier,
    movieDetails: MovieInfo,
    imageWidth: Dp = 135.dp,
    imageHeight: Dp = 210.dp,
) {
    Box(modifier = modifier) {
        Row(verticalAlignment = Alignment.Top) {
            Box(
                modifier = Modifier
                    .height(imageHeight)
                    .width(imageWidth)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(Random.nextLong(0, 0xFFFFFFFF)))
            )
            Spacer(modifier = Modifier.width(MediumSpace))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = movieDetails.title,
                    style = MaterialTheme.typography.h4,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailItem(iconRes = R.drawable.ic_calendar, text = movieDetails.productionYear)
                Spacer(modifier = Modifier.height(12.dp))
                DetailItem(
                    iconRes = R.drawable.ic_clock,
                    text = stringResource(id = R.string.movie_time, movieDetails.durationInMinutes)
                )
                Spacer(modifier = Modifier.height(12.dp))
                DetailItem(iconRes = R.drawable.ic_movie, text = movieDetails.category.name)
            }
        }
        RatingItem(
            rating = movieDetails.rating,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(
                    PaddingSmall
                )
        )
    }
}

@Composable
private fun DetailItem(
    @DrawableRes iconRes: Int,
    text: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = TextGrey
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = TextGrey,
            style = MaterialTheme.typography.h6
        )
    }
}