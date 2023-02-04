package com.silverbullet.core.database.model

import androidx.room.Entity
import androidx.room.Index

@Entity(
    primaryKeys = ["movieId", "categoryId"],
    indices = [
        Index(value = ["categoryId"])
    ]
)
data class MovieCategoryRef(
    val movieId: String,
    val categoryId: Int
)
