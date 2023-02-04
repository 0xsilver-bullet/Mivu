package com.silverbullet.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "t_movies"
)
data class MovieEntity(
    val title: String,
    val overview: String,
    val adult: Boolean,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Float,
    @PrimaryKey(autoGenerate = false)
    val movieId: String
)
