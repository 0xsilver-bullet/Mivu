package com.silverbullet.mivu.di

import android.content.Context
import android.content.SharedPreferences
import com.silverbullet.mivu.core.data.preferences.AndroidPreferences
import com.silverbullet.mivu.core.domain.preferences.Preferences
import com.silverbullet.mivu.core.utils.SharedPrefKeys
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
                SharedPrefKeys.SHARED_PREF_NAME,
                Context.MODE_PRIVATE
            )
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPref: SharedPreferences): Preferences{
        return AndroidPreferences(sharedPref)
    }
}