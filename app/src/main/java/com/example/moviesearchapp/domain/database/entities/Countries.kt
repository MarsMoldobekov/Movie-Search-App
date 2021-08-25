package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity

@Entity(tableName = "Countries", primaryKeys = ["iso_3166_1"])
data class Countries(
    val iso_3166_1: String,
    val english_name: String
)