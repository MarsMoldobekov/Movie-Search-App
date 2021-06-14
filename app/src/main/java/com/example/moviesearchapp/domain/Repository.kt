package com.example.moviesearchapp.domain

import com.example.moviesearchapp.domain.auth.AuthRepository

class Repository {
    private val authRepository: AuthRepository = AuthRepository()

    fun login(username: String, password: String, callback: CallbackNet<Boolean>) {
        authRepository.login(username, password, callback)
    }
}