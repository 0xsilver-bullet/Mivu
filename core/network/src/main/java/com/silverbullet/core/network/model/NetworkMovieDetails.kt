package com.silverbullet.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkMovieDetails(
    val title: String,
    @SerialName("vote_average")
    val voteAverage: Float,
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String,
    val budget: Long,
    val genres: List<NetworkMovieCategory>,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("release_date")
    val releaseDate: String,
    val revenue: Long,
    val id: Int,
    @SerialName("imdb_id")
    val imdbId: String
)
