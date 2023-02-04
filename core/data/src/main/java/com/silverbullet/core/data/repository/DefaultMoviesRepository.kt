package com.silverbullet.core.data.repository

import com.silverbullet.core.data.MoviesRepository
import com.silverbullet.core.database.dao.CategoryDao
import com.silverbullet.core.database.dao.MovieDao
import com.silverbullet.core.database.model.CategoryEntity
import com.silverbullet.core.database.model.asExternalModel
import com.silverbullet.core.model.Category
import com.silverbullet.core.network.MoviesNetworkDataSource
import javax.inject.Inject

class DefaultMoviesRepository @Inject constructor(
    private val categoryDao: CategoryDao,
    private val movieDao: MovieDao,
    private val moviesNetworkDataSource: MoviesNetworkDataSource
) : MoviesRepository {

    override suspend fun getCategories(): List<Category> {
        return categoryDao
            .getCategories()
            .map(CategoryEntity::asExternalModel)
    }
}