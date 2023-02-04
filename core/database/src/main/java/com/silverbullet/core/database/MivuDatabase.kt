package com.silverbullet.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.silverbullet.core.database.dao.CategoryDao
import com.silverbullet.core.database.dao.MovieDao
import com.silverbullet.core.database.model.CategoryEntity
import com.silverbullet.core.database.model.MovieCategoryRef
import com.silverbullet.core.database.model.MovieEntity

@Database(
    entities = [
        CategoryEntity::class,
        MovieEntity::class,
        MovieCategoryRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MivuDatabase : RoomDatabase() {

    abstract fun categoriesDao(): CategoryDao

    abstract fun moviesDao(): MovieDao
}