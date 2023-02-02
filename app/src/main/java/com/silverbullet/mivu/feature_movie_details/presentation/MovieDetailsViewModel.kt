package com.silverbullet.mivu.feature_movie_details.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.silverbullet.mivu.core.domain.model.CategoryItem
import com.silverbullet.mivu.core.domain.model.MovieInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val movieName = "Movie Name"

    val movieStory =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et ante ut sapien bibendum auctor. Vivamus sed ipsum sit amet ligula sodales vehicula vitae quis purus. Fusce vitae odio nec turpis rhoncus hendrerit. Phasellus pretium volutpat pharetra. Nulla facilisi. Ut id commodo massa. Curabitur mauris eros, tristique sit amet purus non, tristique varius nisl. Cras dictum et tortor ac pulvinar. Nulla euismod sed nibh ac congue"

    private val _movieDetails = MutableStateFlow<MovieInfo?>(null)
    val movieDetails = _movieDetails.asStateFlow()

    init {
        _movieDetails.value = MovieInfo(
            "Movie 1",
            productionYear = "1970",
            180,
            CategoryItem("Action", 0),
            rating = 5.0f,
            ""
        )
    }
}