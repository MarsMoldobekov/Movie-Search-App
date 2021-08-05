package com.example.moviesearchapp.viewmodel

import com.example.moviesearchapp.domain.data.Movie

sealed class AppState {
    data class Success(val movies: List<Movie>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
