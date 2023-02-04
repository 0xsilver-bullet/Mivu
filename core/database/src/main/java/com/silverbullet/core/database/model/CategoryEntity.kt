package com.silverbullet.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.silverbullet.core.model.Category

@Entity(
    tableName = "t_categories"
)
data class CategoryEntity(
    @PrimaryKey
    val categoryId: Int,
    val name: String
)

fun CategoryEntity.asExternalModel() = Category(name, categoryId)