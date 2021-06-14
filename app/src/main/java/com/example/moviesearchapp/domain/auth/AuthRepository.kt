package com.example.moviesearchapp.domain.auth

import com.example.moviesearchapp.BuildConfig
import com.example.moviesearchapp.domain.CallbackNet
import com.example.moviesearchapp.domain.data.LoginRequest
import com.example.moviesearchapp.domain.data.LoginResponse
import com.example.moviesearchapp.domain.data.TokenResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val loginApi: LoginApi = retrofit.create(LoginApi::class.java)

    fun login(username: String, password: String, callback: CallbackNet<Boolean>) {
        loginApi.getToken(BuildConfig.TMDB_API_KEY_V3_AUTH).enqueue(
            object : Callback<TokenResponse> {
                override fun onResponse(
                    call: Call<TokenResponse>,
                    response: Response<TokenResponse>
                ) {
                    val loginRequest = response.body()?.requestToken?.let {
                        LoginRequest(username, password, it)
                    }

                    loginApi.login(BuildConfig.TMDB_API_KEY_V3_AUTH, loginRequest)
                        .enqueue(object : Callback<LoginResponse> {
                            override fun onResponse(
                                call: Call<LoginResponse>,
                                response: Response<LoginResponse>
                            ) {
                                response.body()?.success?.let { callback.onSuccess(it) }
                            }

                            override fun onFailure(call: Call<LoginResponse>, throwable: Throwable) {
                                callback.onError(throwable)
                            }
                        })
                }

                override fun onFailure(call: Call<TokenResponse>, throwable: Throwable) {
                    callback.onError(throwable)
                }
            })
    }
}