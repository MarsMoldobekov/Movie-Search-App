package com.example.moviesearchapp.domain.net

interface CallbackNet<T> {
    fun onSuccess(value: T)
    fun onError(throwable: Throwable)
}