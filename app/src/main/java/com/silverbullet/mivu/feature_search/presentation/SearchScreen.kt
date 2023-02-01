package com.silverbullet.mivu.feature_search.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.silverbullet.core_ui.LocalSpacing
import com.silverbullet.mivu.core.presentation.components.DefaultTextInput
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_search.presentation.components.RecommendedForYou
import com.silverbullet.mivu.feature_search.presentation.components.SearchResultsSection

@ExperimentalAnimationApi
@Composable
fun SearchScreen(viewModel: SearchViewModel = hiltViewModel()) {

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
            DefaultTextInput(
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