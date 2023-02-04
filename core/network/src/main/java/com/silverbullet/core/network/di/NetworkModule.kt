package com.silverbullet.core.network.di

import com.silverbullet.core.network.MoviesNetworkDataSource
import com.silverbullet.core.network.retrofit.RetrofitMoviesNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindsMoviesNetworkDatasource(
        moviesNetworkDataSource: RetrofitMoviesNetworkDataSource
    ): MoviesNetworkDataSource
}