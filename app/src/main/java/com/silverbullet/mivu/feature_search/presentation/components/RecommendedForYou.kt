package com.silverbullet.mivu.feature_search.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.domain.model.MovieInfo
import com.silverbullet.mivu.core.presentation.components.MovieInfoItem
import com.silverbullet.mivu.core.presentation.ui.theme.BlueAccent

@Composable
fun RecommendedForYou(
    modifier: Modifier = Modifier,
    recommendedMovies: List<MovieInfo>,
    onClick: (MovieInfo) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.recommended),
                style = MaterialTheme.typography.h4,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.h6,
                color = BlueAccent
            )
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.smallSpace),
            horizontalArrangement = Arrangement.spacedBy(LocalSpacing.current.smallSpace)
        ) {
            items(recommendedMovies) { movieInfo ->
                MovieInfoItem(
                    movieInfo = movieInfo,
                    onClick = { onClick(movieInfo) }
                )
            }
        }
    }
}