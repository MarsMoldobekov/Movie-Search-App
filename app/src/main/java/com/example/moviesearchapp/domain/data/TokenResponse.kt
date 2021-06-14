package com.example.moviesearchapp.domain.data

data class TokenResponse(
    val expires_at: String?,
    val request_token: String?,
    val success: Boolean?
)