package com.example.moviesearchapp.domain

import com.example.moviesearchapp.domain.auth.AuthRepository
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.domain.data.MovieDetails
import com.example.moviesearchapp.domain.movies.MoviesRepository

class Repository {
    private val authRepository = AuthRepository()
    private val moviesRepository = MoviesRepository()

    fun login(username: String, password: String, callback: CallbackNet<Boolean>) {
        authRepository.login(username, password, callback)
    }

    fun getUpcoming(
        callbackNet: CallbackNet<List<Movie>>,
        language: String = "en_US",
        page: Int = 1,
        region: String = "US"
    ) {
        moviesRepository.getUpcoming(language, page, region, callbackNet)
    }

    fun getPopular(
        callbackNet: CallbackNet<List<Movie>>,
        language: String = "en_US",
        page: Int = 1,
        region: String = "US"
    ) {
        moviesRepository.getPopular(language, page, region, callbackNet)
    }

    fun getTopRated(
        callbackNet: CallbackNet<List<Movie>>,
        language: String = "en_US",
        page: Int = 1,
        region: String = "US"
    ) {
        moviesRepository.getTopRated(language, page, region, callbackNet)
    }

    fun getDetails(
        movieId: Int,
        callbackNet: CallbackNet<MovieDetails>,
        language: String = "en_US"
    ) {
        moviesRepository.getDetails(movieId, language, callbackNet)
    }
}