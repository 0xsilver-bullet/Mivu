package com.silverbullet.feature.search

import androidx.lifecycle.ViewModel
import com.silverbullet.feature.search.model.SearchResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _recommendedMovies = MutableStateFlow<List<com.silverbullet.core.model.MovieInfo>>(emptyList())
    val recommendedMovies = _recommendedMovies.asStateFlow()

    private val _searchResults = MutableStateFlow<SearchResults?>(null)
    val searchResults = _searchResults.asStateFlow()

    fun updateSearchText(value: String) {
        _searchText.value = value
    }

    fun cancelSearch() {
        _isSearching.value = false
        _searchText.value = ""
        // TODO: Cancel the search
    }
}