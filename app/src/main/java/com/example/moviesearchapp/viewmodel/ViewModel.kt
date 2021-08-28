package com.example.moviesearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearchapp.App
import com.example.moviesearchapp.domain.net.CallbackNet
import com.example.moviesearchapp.domain.Repository
import com.example.moviesearchapp.domain.net.data.*

class ViewModel : ViewModel() {
    private val liveDataAuth = MutableLiveData<AppStateLoading>()

    private val liveDataError = MutableLiveData<Throwable>()
    private val liveDataUpcoming = MutableLiveData<List<Movie>>()
    private val liveDataPopular = MutableLiveData<List<Movie>>()
    private val liveDataTopRated = MutableLiveData<List<Movie>>()

    private val liveDataMovieDetails = MutableLiveData<MovieDetails>()
    private val liveDataMovieDetailsError = MutableLiveData<Throwable>()

    private val liveDataLoadingGenres = MutableLiveData<AppStateLoading>()
    private val liveDataLoadingCountries = MutableLiveData<AppStateLoading>()
    private val liveDataLoadingLanguages = MutableLiveData<AppStateLoading>()

    private val repository = Repository(App.getMoviesHistoryDao())

    fun onLoginButtonPressed(username: String, password: String) {
        liveDataAuth.value = AppStateLoading.Loading
        repository.login(username, password, object : CallbackNet<Any> {
            override fun onSuccess(value: Any) {
                liveDataAuth.postValue(AppStateLoading.Success(true))
            }

            override fun onError(throwable: Throwable) {
                liveDataAuth.postValue(AppStateLoading.Error(throwable))
            }
        })
    }

    fun onItemPressed(movie: Movie) {
        repository.getDetails(movie.id, object : CallbackNet<MovieDetails> {
            override fun onSuccess(value: MovieDetails) {
                liveDataMovieDetails.value = value
            }

            override fun onError(throwable: Throwable) {
                liveDataMovieDetailsError.value = throwable
            }
        })
    }

    fun requestUpcoming() {
        repository.getUpcoming(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataUpcoming.value = value
            }

            override fun onError(throwable: Throwable) {
                liveDataError.value = throwable
            }
        })
    }

    fun requestPopular() {
        repository.getPopular(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataPopular.value = value
            }

            override fun onError(throwable: Throwable) {
                liveDataError.value = throwable
            }
        })
    }

    fun requestTopRated() {
        repository.getTopRated(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataTopRated.value = value
            }

            override fun onError(throwable: Throwable) {
                liveDataError.value = throwable
            }
        })
    }

    fun loadGenres() {
        repository.loadGenres(object : CallbackNet<List<Genre>> {
            override fun onSuccess(value: List<Genre>) {
                liveDataLoadingGenres.postValue(AppStateLoading.Success(Any()))
                repository.insertGenres(value)
            }

            override fun onError(throwable: Throwable) {
                liveDataLoadingGenres.postValue(AppStateLoading.Error(throwable))
            }
        })
    }

    fun loadCountries() {
        repository.loadCountries(object : CallbackNet<List<Country>> {
            override fun onSuccess(value: List<Country>) {
                liveDataLoadingCountries.postValue(AppStateLoading.Success(Any()))
                repository.insertCountries(value)
            }

            override fun onError(throwable: Throwable) {
                liveDataLoadingCountries.postValue(AppStateLoading.Error(throwable))
            }
        })
    }

    fun loadLanguages() {
        repository.loadLanguages(object : CallbackNet<List<Language>> {
            override fun onSuccess(value: List<Language>) {
                liveDataLoadingLanguages.postValue(AppStateLoading.Success(Any()))
                repository.insertLanguages(value)
            }

            override fun onError(throwable: Throwable) {
                liveDataLoadingLanguages.postValue(AppStateLoading.Error(throwable))
            }
        })
    }

    fun getLiveDataAuth(): LiveData<AppStateLoading> = liveDataAuth

    fun getLiveDataError(): LiveData<Throwable> = liveDataError

    fun getLiveDataUpcoming(): LiveData<List<Movie>> = liveDataUpcoming

    fun getLiveDataPopular(): LiveData<List<Movie>> = liveDataPopular

    fun getLiveDataTopRated(): LiveData<List<Movie>> = liveDataTopRated

    fun getLiveDataMovieDetails(): LiveData<MovieDetails> = liveDataMovieDetails

    fun getLiveDataMovieDetailsError(): LiveData<Throwable> = liveDataMovieDetailsError

    fun getLiveDataLoadingGenres(): LiveData<AppStateLoading> = liveDataLoadingGenres

    fun getLiveDataLoadingCountries(): LiveData<AppStateLoading> = liveDataLoadingCountries

    fun getLiveDataLoadingLanguages(): LiveData<AppStateLoading> = liveDataLoadingLanguages
}