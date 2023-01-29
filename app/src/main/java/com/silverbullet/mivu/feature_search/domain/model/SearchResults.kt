package com.silverbullet.mivu.feature_search.domain.model

import com.silverbullet.mivu.core.domain.model.MovieInfo

data class SearchResults(
    val actors: List<Actor>? = null,
    val movies: List<MovieInfo>
)
