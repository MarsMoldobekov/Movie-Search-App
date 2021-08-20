package com.example.moviesearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearchapp.domain.CallbackNet
import com.example.moviesearchapp.domain.Repository
import com.example.moviesearchapp.domain.data.Movie
import com.example.moviesearchapp.domain.data.MovieDetails

class ViewModel : ViewModel() {
    private val liveDataAuth = MutableLiveData<Boolean>()
    private val liveDataLoginError = MutableLiveData<Throwable>()
    private val liveDataError = MutableLiveData<Throwable>()
    private val liveDataUpcoming = MutableLiveData<List<Movie>>()
    private val liveDataPopular = MutableLiveData<List<Movie>>()
    private val liveDataTopRated = MutableLiveData<List<Movie>>()
    private val liveDataMovieDetails = MutableLiveData<MovieDetails>()
    private val liveDataMovieDetailsError = MutableLiveData<Throwable>()

    private val repository = Repository()

    fun onLoginButtonPressed(username: String, password: String) {
        repository.login(username, password, object : CallbackNet<Boolean> {
            override fun onSuccess(value: Boolean) {
                liveDataAuth.postValue(true)
            }

            override fun onError(throwable: Throwable) {
                liveDataLoginError.postValue(throwable)
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

    fun getLiveDataAuth(): LiveData<Boolean> = liveDataAuth

    fun getLiveDataError(): LiveData<Throwable> = liveDataError

    fun getLiveDataLoginError(): LiveData<Throwable> = liveDataLoginError

    fun getLiveDataUpcoming(): LiveData<List<Movie>> = liveDataUpcoming

    fun getLiveDataPopular(): LiveData<List<Movie>> = liveDataPopular

    fun getLiveDataTopRated(): LiveData<List<Movie>> = liveDataTopRated

    fun getLiveDataMovieDetails(): LiveData<MovieDetails> = liveDataMovieDetails

    fun getLiveDataMovieDetailsError(): LiveData<Throwable> = liveDataMovieDetailsError
}