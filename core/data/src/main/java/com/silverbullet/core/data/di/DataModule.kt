package com.silverbullet.core.data.di

import com.silverbullet.core.data.MoviesRepository
import com.silverbullet.core.data.Preferences
import com.silverbullet.core.data.repository.AndroidPreferences
import com.silverbullet.core.data.repository.DefaultMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsPreferences(
        androidPreferences: AndroidPreferences
    ): Preferences

    @Binds
    fun bindsMoviesRepository(
        moviesRepository: DefaultMoviesRepository
    ): MoviesRepository
}