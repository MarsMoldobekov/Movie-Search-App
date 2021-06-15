package com.example.moviesearchapp.domain.data

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int,
)
