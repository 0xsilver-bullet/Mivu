package com.silverbullet.mivu.feature_favorites.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing
import com.silverbullet.mivu.feature_favorites.presentation.components.DetailedMovieItem

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel = hiltViewModel()) {
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