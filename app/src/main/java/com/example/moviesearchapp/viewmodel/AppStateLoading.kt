package com.example.moviesearchapp.viewmodel

sealed class AppStateLoading {
    data class Success(val value: Any) : AppStateLoading()
    data class Error(val throwable: Throwable) : AppStateLoading()
    object Loading : AppStateLoading()
}
