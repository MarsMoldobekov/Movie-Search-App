package com.example.moviesearchapp.domain.net.api

import com.example.moviesearchapp.domain.net.data.MovieDetails
import com.example.moviesearchapp.domain.net.data.MoviesListResponse
import com.example.moviesearchapp.domain.net.data.UpcomingResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<UpcomingResponse>

    @GET("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<MoviesListResponse>

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<MoviesListResponse>

    //TODO(add parameter appendToResponse
    @GET("movie/{movie_id}")
    fun getDetails(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
    ): Call<MovieDetails>
}