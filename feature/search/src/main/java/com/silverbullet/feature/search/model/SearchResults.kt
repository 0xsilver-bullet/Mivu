package com.silverbullet.feature.search.model

import com.silverbullet.core.model.Actor
import com.silverbullet.core.model.MovieInfo

data class SearchResults(
    val actors: List<Actor>? = null,
    val movies: List<MovieInfo>
)
