package com.silverbullet.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.silverbullet.core.database.model.MovieEntity
import com.silverbullet.core.database.model.MovieWithCategories
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movieEntity: MovieEntity)

    @Transaction
    @Query("SELECT * FROM t_movies")
    fun getMoviesWithCategories(): Flow<List<MovieWithCategories>>
}