package com.silverbullet.mivu.feature_search.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.silverbullet.mivu.core.presentation.components.DefaultList
import com.silverbullet.mivu.feature_search.domain.model.SearchResults
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.domain.model.MovieInfo
import com.silverbullet.mivu.core.presentation.components.MovieInfoItem
import com.silverbullet.mivu.core.presentation.ui.theme.LocalSpacing
import com.silverbullet.mivu.feature_search.domain.model.Actor

@Composable
fun SearchResultsSection(
    modifier: Modifier = Modifier,
    searchResults: SearchResults,
    onActorClick: (Actor) -> Unit = {},
    onMovieClick: (MovieInfo) -> Unit = {}
) {
    Column(modifier = modifier.fillMaxSize()) {
        if (searchResults.actors != null) {
            DefaultList(title = stringResource(id = R.string.actors)) {
                items(searchResults.actors) { actor ->
                    ActorItem(actor = actor, onClick = onActorClick)
                }
            }
            Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        }
        LazyColumn {
            items(searchResults.movies) { movieInfo ->
                MovieInfoItem(movieInfo = movieInfo, onClick = onMovieClick)
            }
        }
    }
}