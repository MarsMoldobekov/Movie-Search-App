package com.example.moviesearchapp.domain.net.api

import com.example.moviesearchapp.domain.net.data.LoginRequest
import com.example.moviesearchapp.domain.net.data.LoginResponse
import com.example.moviesearchapp.domain.net.data.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginApi {
    @GET("authentication/token/new")
    fun getToken(@Query("api_key") api_key: String): Call<TokenResponse>

    @POST("authentication/token/validate_with_login")
    fun login(
        @Query("api_key") api_key: String,
        @Body request: LoginRequest?
    ): Call<LoginResponse>
}