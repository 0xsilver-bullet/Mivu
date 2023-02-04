package com.silverbullet.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.silverbullet.core.database.model.CategoryEntity

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryEntity: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCategories(categories: List<CategoryEntity>)

    @Query("SELECT * FROM t_categories")
    suspend fun getCategories(): List<CategoryEntity>
}