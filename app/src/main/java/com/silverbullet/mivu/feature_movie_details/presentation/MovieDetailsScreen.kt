package com.silverbullet.mivu.feature_movie_details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.core_ui.MivuIconButton
import com.silverbullet.mivu.core.presentation.ui.theme.Dark
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.components.RatingItem
import com.silverbullet.mivu.core.presentation.ui.theme.BlueAccent
import com.silverbullet.mivu.feature_movie_details.presentation.components.BasicInfoItem
import com.silverbullet.mivu.feature_movie_details.presentation.components.CircularIconButton
import com.silverbullet.mivu.feature_movie_details.presentation.components.MovieStory
import com.silverbullet.mivu.feature_movie_details.presentation.components.VerticalSeparator

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    val movieInfo = viewModel.movieDetails.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .background(Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Dark.copy(0.2f), Dark)
                        )
                    )
            )
        }
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.largeSpace)
        ) {
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace * 2))
            movieInfo.value?.let { movie ->
                Box(
                    modifier = Modifier
                        .width(205.dp)
                        .aspectRatio(3f / 4f)
                        .background(Color.Red)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicInfoItem(iconRes = R.drawable.ic_calendar, data = movie.productionYear)
                    VerticalSeparator()
                    BasicInfoItem(
                        iconRes = R.drawable.ic_clock,
                        data = "${movie.durationInMinutes} minutes"
                    )
                    VerticalSeparator()
                    BasicInfoItem(iconRes = R.drawable.ic_movie, data = movie.category.name)
                }
                RatingItem(rating = movie.rating)
                CircularIconButton(
                    contentDescription = stringResource(id = R.string.share_movie),
                    iconRes = R.drawable.ic_share,
                    tint = BlueAccent
                )
                MovieStory(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = LocalSpacing.current.largeSpace),
                    story = viewModel.movieStory
                )
                Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
            }
        }
        TopSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = LocalSpacing.current.largeSpace,
                    vertical = LocalSpacing.current.smallSpace
                ),
            movieName = viewModel.movieName,
            onBackClick = navigateBack,
            onFavoriteClick = {
                // TODO: Mark as favorite
            }
        )
    }
}

@Composable
private fun TopSection(
    modifier: Modifier = Modifier,
    movieName: String,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MivuIconButton(
            iconRes = R.drawable.ic_back,
            callback = onBackClick
        )
        Text(
            text = movieName,
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        MivuIconButton(
            iconRes = R.drawable.ic_favorite,
            tint = Color.Red,
            callback = onFavoriteClick
        )
    }
}