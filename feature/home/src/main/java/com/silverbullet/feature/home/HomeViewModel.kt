package com.silverbullet.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silverbullet.core.data.MoviesRepository
import com.silverbullet.core.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories = _categories.asStateFlow()

    init {
        viewModelScope.launch {
            _categories.value = moviesRepository.getCategories()
        }
    }
}