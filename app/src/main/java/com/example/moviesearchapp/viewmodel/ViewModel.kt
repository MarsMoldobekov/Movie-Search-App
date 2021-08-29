package com.example.moviesearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesearchapp.domain.Repository
import com.example.moviesearchapp.domain.net.CallbackNet
import com.example.moviesearchapp.domain.net.data.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    private val liveDataLoadingGenres = MutableLiveData<AppStateLoading>()
    private val liveDataLoadingCountries = MutableLiveData<AppStateLoading>()
    private val liveDataLoadingLanguages = MutableLiveData<AppStateLoading>()

    private val liveDataAuth = MutableLiveData<AppStateLoading>()

    private val liveDataUpcoming = MutableLiveData<AppStateLoadingListMovie>()
    private val liveDataPopular = MutableLiveData<AppStateLoadingListMovie>()
    private val liveDataTopRated = MutableLiveData<AppStateLoadingListMovie>()

    private val liveDataMovieDetails = MutableLiveData<AppStateLoadingMovieDetails>()

    private val repository = Repository()

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
        liveDataMovieDetails.value = AppStateLoadingMovieDetails.Loading
        repository.getDetails(movie.id, object : CallbackNet<MovieDetails> {
            override fun onSuccess(value: MovieDetails) {
                liveDataMovieDetails.postValue(AppStateLoadingMovieDetails.Success(value))
                viewModelScope.launch(Dispatchers.IO) { repository.insertMovie(value) }
            }

            override fun onError(throwable: Throwable) {
                liveDataMovieDetails.postValue(AppStateLoadingMovieDetails.Error(throwable))
            }
        })
    }

    fun requestUpcoming() {
        liveDataUpcoming.value = AppStateLoadingListMovie.Loading
        repository.getUpcoming(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataUpcoming.postValue(AppStateLoadingListMovie.Success(value))
            }

            override fun onError(throwable: Throwable) {
                liveDataUpcoming.postValue(AppStateLoadingListMovie.Error(throwable))
            }
        })
    }

    fun requestPopular() {
        liveDataPopular.value = AppStateLoadingListMovie.Loading
        repository.getPopular(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataPopular.postValue(AppStateLoadingListMovie.Success(value))
            }

            override fun onError(throwable: Throwable) {
                liveDataPopular.postValue(AppStateLoadingListMovie.Error(throwable))
            }
        })
    }

    fun requestTopRated() {
        liveDataTopRated.value = AppStateLoadingListMovie.Loading
        repository.getTopRated(object : CallbackNet<List<Movie>> {
            override fun onSuccess(value: List<Movie>) {
                liveDataTopRated.postValue(AppStateLoadingListMovie.Success(value))
            }

            override fun onError(throwable: Throwable) {
                liveDataTopRated.postValue(AppStateLoadingListMovie.Error(throwable))
            }
        })
    }

    fun loadGenres() {
        repository.loadGenres(object : CallbackNet<List<Genre>> {
            override fun onSuccess(value: List<Genre>) {
                liveDataLoadingGenres.postValue(AppStateLoading.Success(Any()))
                viewModelScope.launch(Dispatchers.IO) { repository.insertGenres(value) }
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
                viewModelScope.launch(Dispatchers.IO) { repository.insertCountries(value) }
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
                viewModelScope.launch { repository.insertLanguages(value) }
            }

            override fun onError(throwable: Throwable) {
                liveDataLoadingLanguages.postValue(AppStateLoading.Error(throwable))
            }
        })
    }

    fun getLiveDataAuth(): LiveData<AppStateLoading> = liveDataAuth

    fun getLiveDataUpcoming(): LiveData<AppStateLoadingListMovie> = liveDataUpcoming

    fun getLiveDataPopular(): LiveData<AppStateLoadingListMovie> = liveDataPopular

    fun getLiveDataTopRated(): LiveData<AppStateLoadingListMovie> = liveDataTopRated

    fun getLiveDataMovieDetails(): LiveData<AppStateLoadingMovieDetails> = liveDataMovieDetails

    fun getLiveDataLoadingGenres(): LiveData<AppStateLoading> = liveDataLoadingGenres

    fun getLiveDataLoadingCountries(): LiveData<AppStateLoading> = liveDataLoadingCountries

    fun getLiveDataLoadingLanguages(): LiveData<AppStateLoading> = liveDataLoadingLanguages
}