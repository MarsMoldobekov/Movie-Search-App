package com.example.moviesearchapp.domain.data

import com.google.gson.annotations.SerializedName

data class UpcomingResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("dates") val dates: Dates,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
)
