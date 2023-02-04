package com.silverbullet.core.data

import com.silverbullet.core.model.Category

interface MoviesRepository {

    suspend fun getCategories(): List<Category>
}