package com.example.moviesearchapp.domain.net.data

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Long,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String
)