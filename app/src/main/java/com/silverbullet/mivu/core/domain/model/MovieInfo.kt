package com.silverbullet.mivu.core.domain.model

data class MovieInfo(
    val title: String,
    val productionYear: String,
    val durationInMinutes: Int,
    val category: CategoryItem,
    val rating: Float,
    val imageUrl: String
)
