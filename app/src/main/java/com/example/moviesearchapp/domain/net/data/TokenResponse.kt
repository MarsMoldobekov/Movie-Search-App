package com.example.moviesearchapp.domain.net.data

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("success") val success: Boolean?,
    @SerializedName("expires_at") val expiresAt: String?,
    @SerializedName("request_token") val requestToken: String?
)