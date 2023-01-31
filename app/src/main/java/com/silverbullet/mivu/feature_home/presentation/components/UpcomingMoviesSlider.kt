package com.silverbullet.mivu.feature_home.presentation.components

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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing
import com.silverbullet.mivu.feature_home.domain.model.UpcomingMovie
import kotlin.math.absoluteValue
import kotlin.random.Random

@ExperimentalPagerApi
@Composable
fun UpcomingMoviesSlider(
    modifier: Modifier = Modifier,
    upcomingMovies: List<UpcomingMovie>,
    onClick: (UpcomingMovie) -> Unit
) {
    HorizontalPager(
        modifier = modifier,
        count = upcomingMovies.size,
        contentPadding = PaddingValues(horizontal = 42.dp)
    ) { page ->
        Box(
            modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                    lerp(
                        start = ScaleFactor(0.85f, 0.85f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.scaleX
                        scaleY = scale.scaleY
                    }
                    alpha = lerp(
                        start = ScaleFactor(0.85f, 0.85f),
                        stop = ScaleFactor(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).scaleX
                },
            contentAlignment = Alignment.Center
        ){
            UpcomingMovieItem(
                item = upcomingMovies[page],
                modifier = Modifier,
                onClick = onClick
            )
        }

    }
}

@Composable
fun UpcomingMovieItem(
    modifier: Modifier = Modifier,
    item: UpcomingMovie,
    onClick: (UpcomingMovie) -> Unit = {}
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(Random.nextLong(0, 0xFFFFFFFF)))
                .clickable { onClick(item) }
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = LocalSpacing.current.mediumSpace, bottom = LocalSpacing.current.mediumSpace)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.formattedDate,
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
        }
    }
}