package com.example.moviesearchapp.domain

interface CallbackNet<T> {
    fun onSuccess(value: T)
    fun onError(throwable: Throwable)
}