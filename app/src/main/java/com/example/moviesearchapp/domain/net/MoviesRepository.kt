package com.example.moviesearchapp.domain.net

import com.example.moviesearchapp.BuildConfig
import com.example.moviesearchapp.domain.net.api.MoviesApi
import com.example.moviesearchapp.domain.net.data.Movie
import com.example.moviesearchapp.domain.net.data.MovieDetails
import com.example.moviesearchapp.domain.net.data.MoviesListResponse
import com.example.moviesearchapp.domain.net.data.UpcomingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val moviesApi: MoviesApi = retrofit.create(MoviesApi::class.java)

    fun getUpcoming(
        language: String,
        page: Int,
        region: String,
        callbackNet: CallbackNet<List<Movie>>
    ) {
        moviesApi.getUpcoming(BuildConfig.TMDB_API_KEY_V3_AUTH, language, page, region)
            .enqueue(object : Callback<UpcomingResponse> {
                override fun onResponse(
                    call: Call<UpcomingResponse>,
                    response: Response<UpcomingResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<UpcomingResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }

    fun getPopular(
        language: String,
        page: Int,
        region: String,
        callbackNet: CallbackNet<List<Movie>>
    ) {
        moviesApi.getPopular(BuildConfig.TMDB_API_KEY_V3_AUTH, language, page, region)
            .enqueue(object : Callback<MoviesListResponse> {
                override fun onResponse(
                    call: Call<MoviesListResponse>,
                    response: Response<MoviesListResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<MoviesListResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }

    fun getTopRated(
        language: String,
        page: Int,
        region: String,
        callbackNet: CallbackNet<List<Movie>>
    ) {
        moviesApi.getTopRated(BuildConfig.TMDB_API_KEY_V3_AUTH, language, page, region)
            .enqueue(object : Callback<MoviesListResponse> {
                override fun onResponse(
                    call: Call<MoviesListResponse>,
                    response: Response<MoviesListResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<MoviesListResponse>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }

    fun getDetails(movieId: Int, language: String, callbackNet: CallbackNet<MovieDetails>) {
        moviesApi.getDetails(movieId, BuildConfig.TMDB_API_KEY_V3_AUTH, language)
            .enqueue(object : Callback<MovieDetails> {
                override fun onResponse(
                    call: Call<MovieDetails>,
                    response: Response<MovieDetails>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callbackNet.onSuccess(it) }
                    }
                }

                override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                    callbackNet.onError(t)
                }
            })
    }
}