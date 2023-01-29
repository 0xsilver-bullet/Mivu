package com.silverbullet.mivu.feature_home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.silverbullet.mivu.R
import com.silverbullet.mivu.core.domain.model.CategoryItem
import com.silverbullet.mivu.core.domain.model.MovieInfo
import com.silverbullet.mivu.core.presentation.components.CategoryCard
import com.silverbullet.mivu.core.presentation.components.DefaultList
import com.silverbullet.mivu.core.presentation.components.DefaultTextInput
import com.silverbullet.mivu.core.presentation.components.MovieInfoItem
import com.silverbullet.mivu.core.presentation.ui.theme.*
import com.silverbullet.mivu.feature_home.domain.model.UpcomingMovie
import com.silverbullet.mivu.feature_home.presentation.components.HomeTop
import com.silverbullet.mivu.feature_home.presentation.components.UpcomingMoviesSlider
import com.silverbullet.mivu.navigation.utils.Screen

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navCallback: (Screen) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        HomeTop(
            title = "Aly",
            subTitle = stringResource(id = R.string.home_sub_title),
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Soft)
                        .clickable {
                            navCallback(Screen.FavoritesScreen)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_favorite),
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PaddingLarge)
        )
        Spacer(modifier = Modifier.height(32.dp))
        var searchInput by remember {
            mutableStateOf("")
        }
        DefaultTextInput(
            value = searchInput,
            onValueChanged = { searchInput = it },
            hint = "Search a title",
            textStyle = MaterialTheme.typography.h5.copy(color = TextGrey),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = TextGrey
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = PaddingLarge)
        )
        Spacer(modifier = Modifier.height(LargeSpace))
        UpcomingMoviesSlider(
            upcomingMovies = listOf(
                UpcomingMovie(
                    "Name of Movie",
                    "on July 11",
                    "NO RUL",
                    ""
                ),
                UpcomingMovie(
                    "Name of Movie",
                    "on July 11",
                    "NO RUL",
                    ""
                ), UpcomingMovie(
                    "Name of Movie",
                    "on July 11",
                    "NO RUL",
                    ""
                )
            ),
            onClick = {
                // TODO: Navigate to Movie Details}
            },
            modifier = Modifier.fillMaxHeight(0.3f)
        )
        Spacer(modifier = Modifier.height(LargeSpace))
        DefaultList(
            title = stringResource(id = R.string.categories),
            modifier = Modifier.padding(start = PaddingLarge)
        ) {
            items(1000) {
                CategoryCard(
                    item = CategoryItem("Category $it", it),
                    selected = it == 1,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(LargeSpace))
        DefaultList(
            title = stringResource(id = R.string.most_popular),
            modifier = Modifier.padding(start = PaddingLarge)
        ) {
            items(10000) {
                MovieInfoItem(
                    movieInfo = MovieInfo(
                        "Movie $it",
                        "1970",
                        180,
                        CategoryItem("Action", 0),
                        4.9f,
                        ""
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}