package com.silverbullet.core.network

import com.silverbullet.core.network.model.NetworkMovieCategory
import com.silverbullet.core.network.model.NetworkMovieDetails
import com.silverbullet.core.network.model.NetworkMovieInfo

interface MoviesNetworkDataSource {

    suspend fun getUpcomingMovies(page: Int): List<NetworkMovieInfo>

    suspend fun getPopularMovies(page: Int): List<NetworkMovieInfo>

    suspend fun getMovieDetails(movieId: Int): NetworkMovieDetails

    suspend fun getRecommendationsForMovie(movieId: Int): List<NetworkMovieInfo>

    suspend fun getCategories(): List<NetworkMovieCategory>
}