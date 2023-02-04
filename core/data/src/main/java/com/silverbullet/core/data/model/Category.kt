package com.silverbullet.core.data.model

import com.silverbullet.core.database.model.CategoryEntity
import com.silverbullet.core.network.model.NetworkMovieCategory

fun NetworkMovieCategory.toEntity(): CategoryEntity = CategoryEntity(
    categoryId = id,
    name = name
)