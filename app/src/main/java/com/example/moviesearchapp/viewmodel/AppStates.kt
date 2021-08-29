package com.example.moviesearchapp.viewmodel

import com.example.moviesearchapp.domain.net.data.Movie
import com.example.moviesearchapp.domain.net.data.MovieDetails

//TODO(combine three AppStates)

sealed class AppStateLoading {
    data class Success(val value: Any) : AppStateLoading()
    data class Error(val throwable: Throwable) : AppStateLoading()
    object Loading : AppStateLoading()
}

sealed class AppStateLoadingListMovie {
    data class Success(val value: List<Movie>) : AppStateLoadingListMovie()
    data class Error(val throwable: Throwable) : AppStateLoadingListMovie()
    object Loading : AppStateLoadingListMovie()
}

sealed class AppStateLoadingMovieDetails {
    data class Success(val value: MovieDetails) : AppStateLoadingMovieDetails()
    data class Error(val throwable: Throwable) : AppStateLoadingMovieDetails()
    object Loading : AppStateLoadingMovieDetails()
}