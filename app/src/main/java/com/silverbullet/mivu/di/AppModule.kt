package com.silverbullet.mivu.di

import android.content.Context
import android.content.SharedPreferences
import com.silverbullet.core.data.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext app: Context): SharedPreferences {
        return app
            .getSharedPreferences(
                Preferences.SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
    }
}