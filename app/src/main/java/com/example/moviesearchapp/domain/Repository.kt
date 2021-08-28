package com.example.moviesearchapp.domain

import com.example.moviesearchapp.domain.database.dao.MoviesHistoryDao
import com.example.moviesearchapp.domain.net.AuthRepository
import com.example.moviesearchapp.domain.net.MoviesRepository
import com.example.moviesearchapp.domain.net.CallbackNet
import com.example.moviesearchapp.domain.net.EntitiesRepository
import com.example.moviesearchapp.domain.net.data.*

class Repository(
    private val moviesHistoryDao: MoviesHistoryDao
) {
    private val authRepository = AuthRepository()
    private val moviesRepository = MoviesRepository()
    private val entitiesRepository = EntitiesRepository()
    private val converter = Converter()

    fun login(username: String, password: String, callback: CallbackNet<Any>) {
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
        movieId: Long,
        callbackNet: CallbackNet<MovieDetails>,
        language: String = "en_US"
    ) {
        moviesRepository.getDetails(movieId, language, callbackNet)
    }

    fun loadGenres(callbackNet: CallbackNet<List<Genre>>) {
        entitiesRepository.loadGenres(callbackNet)
    }

    fun loadCountries(callbackNet: CallbackNet<List<Country>>) {
        entitiesRepository.loadCountries(callbackNet)
    }

    fun loadLanguages(callbackNet: CallbackNet<List<Language>>) {
        entitiesRepository.loadLanguages(callbackNet)
    }

    fun insertGenres(genres: List<Genre>) {
        moviesHistoryDao.insertGenres(converter.convert(genres))
    }

    fun insertCountries(countries: List<Country>) {
        moviesHistoryDao.insertCountries(converter.convert(countries))
    }

    fun insertLanguages(languages: List<Language>) {
        moviesHistoryDao.insertLanguages(converter.convert(languages))
    }
}