package com.silverbullet.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.silverbullet.core.model.Category
import com.silverbullet.core.model.MovieInfo
import com.silverbullet.core.model.UpcomingMovie
import com.silverbullet.core.ui.*
import com.silverbullet.core.ui.MovieInfoItem
import kotlin.math.absoluteValue
import kotlin.random.Random

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun HomeScreen(
    onFavoritesClick: () -> Unit,
    onMovieClick: (String, String) -> Unit
) {
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
                        .clickable { onFavoritesClick() },
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
                .padding(horizontal = LocalSpacing.current.largeSpace)
        )
        Spacer(modifier = Modifier.height(32.dp))
        var searchInput by remember {
            mutableStateOf("")
        }
        SearchTextInput(
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
                .padding(horizontal = LocalSpacing.current.largeSpace)
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
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
            onClick = { onMovieClick(it.id, it.title) },
            modifier = Modifier.fillMaxHeight(0.3f)
        )
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        DefaultList(
            title = stringResource(id = R.string.categories),
            modifier = Modifier.padding(start = LocalSpacing.current.largeSpace)
        ) {
            items(1000) {
                CategoryCard(
                    item = Category("Category $it", it),
                    selected = it == 1,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.largeSpace))
        DefaultList(
            title = stringResource(id = R.string.most_popular),
            modifier = Modifier.padding(start = LocalSpacing.current.largeSpace)
        ) {
            items(10000) {
                MovieInfoItem(
                    movieInfo = MovieInfo(
                        "Movie $it",
                        "1970",
                        180,
                        Category("Action", 0),
                        4.9f,
                        ""
                    ),
                    onClick = { onMovieClick(it.title , it.title)}
                )
                // TODO: pass movie id to on click !!!!!!!!!!!!!!!!!!
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
private fun HomeTop(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.h4,
    subTitle: String,
    subTitleStyle: TextStyle = MaterialTheme.typography.h5,
    trailingIcon: @Composable () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                stringResource(id = R.string.hello, title),
                style = titleStyle,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subTitle,
                style = subTitleStyle,
                color = TextGrey
            )
        }
        trailingIcon()
    }
}

@Composable
private fun CategoryCard(
    item: Category,
    selected: Boolean,
    onClick: (Category) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.h6,
    verticalPadding: Dp = LocalSpacing.current.smallSpace,
    horizontalPadding: Dp = 32.dp
) {
    val boxModifier = Modifier
        .clip(RoundedCornerShape(8.dp))
        .background(if (selected) Soft else Dark)
        .clickable {
            if (!selected) {
                onClick(item)
            }
        }
        .padding(horizontal = horizontalPadding, vertical = verticalPadding)

    Box(modifier = boxModifier, contentAlignment = Alignment.Center) {
        Text(text = item.name, style = textStyle, color = if (selected) BlueAccent else Color.White)
    }
}

@ExperimentalPagerApi
@Composable
private fun UpcomingMoviesSlider(
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
        ) {
            UpcomingMovieItem(
                item = upcomingMovies[page],
                modifier = Modifier,
                onClick = onClick
            )
        }

    }
}

@Composable
private fun UpcomingMovieItem(
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
                .padding(
                    start = LocalSpacing.current.mediumSpace,
                    bottom = LocalSpacing.current.mediumSpace
                )
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