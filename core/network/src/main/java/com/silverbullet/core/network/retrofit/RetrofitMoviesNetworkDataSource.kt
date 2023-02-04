package com.silverbullet.core.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.silverbullet.core.network.BuildConfig
import com.silverbullet.core.network.MoviesNetworkDataSource
import com.silverbullet.core.network.model.CategoriesNetworkResponse
import com.silverbullet.core.network.model.NetworkMovieCategory
import com.silverbullet.core.network.model.NetworkMovieDetails
import com.silverbullet.core.network.model.NetworkMovieInfo
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface TMDBAPI {

    @GET("movie/upcoming")
    suspend fun fetchUpcomingMovies(
        @Query("api_key") apiKey: String = tmdbApiKey,
        @Query("page") page: Int = 1
    ): TMDBResponse<NetworkMovieInfo>

    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("api_key") apiKey: String = tmdbApiKey,
        @Query("page") page: Int = 1
    ): TMDBResponse<NetworkMovieInfo>

    @GET("genre/movie/list")
    suspend fun fetchMoviesCategories(
        @Query("api_key") apiKey: String = tmdbApiKey
    ): CategoriesNetworkResponse

    @GET("movie/{movieId}")
    suspend fun fetchMovieDetails(
        @Query("api_key") apiKey: String = tmdbApiKey,
        @Path("movieId") movieId: Int
    ): NetworkMovieDetails

    @GET("movie/{movieId}/recommendations")
    suspend fun fetchRecommendationsForMovie(
        @Query("api_key") apiKey: String = tmdbApiKey,
        @Path("movieId") movieId: Int
    ): TMDBResponse<NetworkMovieInfo>

    companion object {
        const val url = BuildConfig.TMDBUrl
        const val tmdbApiKey = BuildConfig.TMDBApiKey
    }
}

@Serializable
private data class TMDBResponse<T>(
    val results: List<T>
)

@Singleton
class RetrofitMoviesNetworkDataSource @Inject constructor(
    networkJson: Json
) : MoviesNetworkDataSource {

    private val client = OkHttpClient
        .Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .build()

    @OptIn(ExperimentalSerializationApi::class)
    private val api = Retrofit
        .Builder()
        .baseUrl(TMDBAPI.url)
        .client(client)
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(TMDBAPI::class.java)

    override suspend fun getUpcomingMovies(page: Int): List<NetworkMovieInfo> {
        return api
            .fetchUpcomingMovies(page = page)
            .results
    }

    override suspend fun getPopularMovies(page: Int): List<NetworkMovieInfo> {
        return api
            .fetchPopularMovies(page = page)
            .results
    }

    override suspend fun getMovieDetails(movieId: Int): NetworkMovieDetails {
        return api
            .fetchMovieDetails(movieId = movieId)
    }

    override suspend fun getRecommendationsForMovie(movieId: Int): List<NetworkMovieInfo> {
        return api
            .fetchRecommendationsForMovie(movieId = movieId)
            .results
    }

    override suspend fun getCategories(): List<NetworkMovieCategory> {
        return api
            .fetchMoviesCategories()
            .genres
    }
}