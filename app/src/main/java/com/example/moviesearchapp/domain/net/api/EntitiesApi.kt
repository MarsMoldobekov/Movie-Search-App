package com.example.moviesearchapp.domain.net.api

import com.example.moviesearchapp.domain.net.data.CountriesResponse
import com.example.moviesearchapp.domain.net.data.GenresResponse
import com.example.moviesearchapp.domain.net.data.LanguagesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EntitiesApi {
    @GET("genre/movie/list")
    fun loadGenres(
        @Query("api_key") api_key: String,
        @Query("language") language: String = "en-US"
    ): Call<GenresResponse>

    @GET("configuration/languages")
    fun loadLanguages(@Query("api_key") api_key: String): Call<LanguagesResponse>

    @GET("configuration/countries")
    fun loadCountries(@Query("api_key") api_key: String): Call<CountriesResponse>
}