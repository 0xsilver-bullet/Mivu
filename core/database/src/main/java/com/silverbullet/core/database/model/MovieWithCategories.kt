package com.silverbullet.core.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.silverbullet.core.model.MovieInfo

data class MovieWithCategories(
    @Embedded val movie: MovieEntity,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "categoryId",
        associateBy = Junction(MovieCategoryRef::class)
    )
    val categories: List<CategoryEntity>
)

fun MovieWithCategories.asExternalModel() = MovieInfo(
    title = movie.title,
    productionYear = movie.releaseDate,
    durationInMinutes = 0,
    category = categories[0].asExternalModel(),
    rating = movie.voteAverage,
    imageUrl = movie.posterPath
)