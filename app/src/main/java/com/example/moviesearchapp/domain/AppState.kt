package com.example.moviesearchapp.domain

sealed class AppState<T> {
    data class Success<T>(val value: T) : AppState<T>()
    data class Error(val throwable: Throwable) : AppState<Throwable>()
}