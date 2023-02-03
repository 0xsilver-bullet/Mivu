package com.silverbullet.core.model

data class MovieInfo(
    val title: String,
    val productionYear: String,
    val durationInMinutes: Int,
    val category: Category,
    val rating: Float,
    val imageUrl: String
)
