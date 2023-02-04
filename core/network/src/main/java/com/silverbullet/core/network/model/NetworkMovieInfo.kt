package com.silverbullet.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMovieInfo(
    @SerialName("poster_path")
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
    @SerialName("genre_ids")
    val genreIds: List<Int>,
    @SerialName("backdrop_path")
    val backdropPath: String,
    @SerialName("vote_average")
    val voteAverage: Float,
    val id: String
)
