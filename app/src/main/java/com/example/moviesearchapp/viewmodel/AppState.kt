package com.example.moviesearchapp.viewmodel

sealed class AppState<T> {
    data class Success<T>(val data: T) : AppState<T>()
    data class Error(val error: Throwable) : AppState<Throwable>()
    object Loading : AppState<Unit>()
}