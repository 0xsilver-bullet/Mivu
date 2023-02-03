package com.silverbullet.core.data.di

import com.silverbullet.core.data.Preferences
import com.silverbullet.core.data.repository.AndroidPreferences
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
}