package com.silverbullet.feature.search

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import com.silverbullet.core.model.Actor
import com.silverbullet.core.ui.*
import com.silverbullet.feature.search.model.SearchResults
import com.silverbullet.core.ui.MovieInfoItem

@ExperimentalAnimationApi
@Composable
internal fun SearchScreen(viewModel: SearchViewModel = hiltViewModel()) {

    val searchText = viewModel.searchText.collectAsState()
    val isSearching = viewModel.isSearching.collectAsState()
    val recommendedMovies = viewModel.recommendedMovies.collectAsState()
    val searchResults = viewModel.searchResults.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = LocalSpacing.current.largeSpace)
    ) {
        Spacer(modifier = Modifier.height(LocalSpacing.current.smallSpace))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            SearchTextInput(
                value = searchText.value,
                onValueChanged = viewModel::updateSearchText,
                modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.h5.copy(color = TextGrey),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        tint = TextGrey,
                        contentDescription = null,
                    )
                },
                hint = stringResource(id = R.string.type_something)
            )
            if (isSearching.value) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    color = Color.White,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(start = LocalSpacing.current.smallSpace)
                        .clickable { viewModel.cancelSearch() }
                )
            }
        }
        AnimatedContent(targetState = isSearching.value) { targetState ->
            when (targetState) {
                false -> {
                    // Show Recommended for you section
                    RecommendedForYou(
                        modifier = Modifier.padding(top = LocalSpacing.current.largeSpace),
                        recommendedMovies = recommendedMovies.value
                    )
                }
                true -> {
                    // Show Search results
                    searchResults.value?.let { results ->
                        SearchResultsSection(
                            searchResults = results,
                            modifier = Modifier.padding(top = LocalSpacing.current.largeSpace)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActorItem(
    modifier: Modifier = Modifier,
    imageSize: Dp = 64.dp,
    actor: Actor,
    onClick: (Actor) -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .size(imageSize)
                .clip(CircleShape)
                .background(Color.Red)
                .clickable { onClick(actor) }
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        Text(
            text = actor.name,
            style = MaterialTheme.typography.h6,
            color = Color.White,
            modifier = Modifier.clickable { onClick(actor) }
        )
    }
}

@Composable
fun RecommendedForYou(
    modifier: Modifier = Modifier,
    recommendedMovies: List<com.silverbullet.core.model.MovieInfo>,
    onClick: (com.silverbullet.core.model.MovieInfo) -> Unit = {}
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

@Composable
fun SearchResultsSection(
    modifier: Modifier = Modifier,
    searchResults: SearchResults,
    onActorClick: (Actor) -> Unit = {},
    onMovieClick: (com.silverbullet.core.model.MovieInfo) -> Unit = {}
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