package com.silverbullet.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkMovieCategory(
    val id: Int,
    val name: String
)

@Serializable
data class CategoriesNetworkResponse(
    val genres: List<NetworkMovieCategory>
)
