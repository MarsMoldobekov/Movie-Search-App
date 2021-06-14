package com.example.moviesearchapp.domain.data

data class LoginResponse(
    val expires_at: String?,
    val request_token: String?,
    val success: Boolean?
)