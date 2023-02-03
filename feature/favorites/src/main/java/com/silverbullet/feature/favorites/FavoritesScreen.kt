package com.silverbullet.feature.favorites

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core.model.MovieInfo
import com.silverbullet.core.ui.LocalSpacing
import com.silverbullet.core.ui.RatingItem
import com.silverbullet.core.ui.TextGrey
import kotlin.random.Random

@Composable
internal fun FavoritesScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
    val movies = viewModel.favoriteMoviesList.collectAsState()

    if (movies.value.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = LocalSpacing.current.largeSpace)
        ) {
            items(movies.value) { movieDetails ->
                DetailedMovieItem(movieDetails = movieDetails)
                Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty),
                contentDescription = stringResource(id = R.string.no_favorites)
            )
        }
    }
}

@Composable
private fun DetailedMovieItem(
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
            Spacer(modifier = Modifier.width(LocalSpacing.current.mediumSpace))
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
                .padding(LocalSpacing.current.smallSpace)
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