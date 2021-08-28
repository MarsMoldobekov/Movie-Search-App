package com.example.moviesearchapp.domain.net

import com.example.moviesearchapp.BuildConfig
import com.example.moviesearchapp.domain.net.api.EntitiesApi
import com.example.moviesearchapp.domain.net.data.*
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EntitiesRepository {
    private val entitiesApi: EntitiesApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(EntitiesApi::class.java)

    fun loadGenres(callbackNet: CallbackNet<List<Genre>>) {
        entitiesApi.loadGenres(BuildConfig.TMDB_API_KEY_V3_AUTH)
            .enqueue(object : Callback<GenresResponse> {
                override fun onResponse(
                    call: Call<GenresResponse>,
                    response: Response<GenresResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<GenresResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }

    fun loadCountries(callbackNet: CallbackNet<List<Country>>) {
        entitiesApi.loadCountries(BuildConfig.TMDB_API_KEY_V3_AUTH)
            .enqueue(object : Callback<CountriesResponse> {
                override fun onResponse(
                    call: Call<CountriesResponse>,
                    response: Response<CountriesResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<CountriesResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }

    fun loadLanguages(callbackNet: CallbackNet<List<Language>>) {
        entitiesApi.loadLanguages(BuildConfig.TMDB_API_KEY_V3_AUTH)
            .enqueue(object : Callback<LanguagesResponse> {
                override fun onResponse(
                    call: Call<LanguagesResponse>,
                    response: Response<LanguagesResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<LanguagesResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }
}