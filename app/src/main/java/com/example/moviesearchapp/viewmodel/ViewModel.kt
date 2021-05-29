package com.example.moviesearchapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearchapp.domain.Repository

class ViewModel : ViewModel() {
    private val liveDataAuth: MutableLiveData<Any> = MutableLiveData()

    private val repository = Repository()

    fun onLoginButtonPressed(username: String, password: String) {
        repository.login(username, password)
        liveDataAuth.value = Any()
    }

    fun getLiveDataAuth(): LiveData<Any> = liveDataAuth
}