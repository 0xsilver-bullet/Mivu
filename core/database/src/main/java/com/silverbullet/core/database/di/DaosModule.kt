package com.silverbullet.core.database.di

import com.silverbullet.core.database.MivuDatabase
import com.silverbullet.core.database.dao.CategoryDao
import com.silverbullet.core.database.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaosModule {

    @Provides
    fun provideCategoriesDao(mivuDatabase: MivuDatabase): CategoryDao = mivuDatabase.categoriesDao()

    @Provides
    fun provideMovieDao(mivuDatabase: MivuDatabase): MovieDao = mivuDatabase.moviesDao()
}