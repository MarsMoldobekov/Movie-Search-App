package com.example.moviesearchapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearchapp.domain.CallbackNet
import com.example.moviesearchapp.domain.Repository

const val TAG = "LOGIN"

class ViewModel : ViewModel() {
    private val liveDataAuth = MutableLiveData<Boolean>()
    private val liveDataError = MutableLiveData<Throwable>()

    private val repository = Repository()

    fun onLoginButtonPressed(username: String, password: String) {
        Log.d(TAG, "$username $password")
        repository.login(username, password, object : CallbackNet<Boolean> {
            override fun onSuccess(value: Boolean) {
                liveDataAuth.value = value
            }

            override fun onError(throwable: Throwable) {
                liveDataError.value = throwable
            }
        })
    }

    fun getLiveDataAuth(): LiveData<Boolean> = liveDataAuth

    fun getLiveDataError(): LiveData<Throwable> = liveDataError
}