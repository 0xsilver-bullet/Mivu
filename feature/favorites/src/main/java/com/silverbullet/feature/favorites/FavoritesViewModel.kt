package com.silverbullet.feature.favorites

import androidx.lifecycle.ViewModel
import com.silverbullet.core.model.MovieInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(): ViewModel() {

    private val _favoriteMoviesList = MutableStateFlow<List<MovieInfo>>(emptyList())
    val favoriteMoviesList = _favoriteMoviesList.asStateFlow()

}