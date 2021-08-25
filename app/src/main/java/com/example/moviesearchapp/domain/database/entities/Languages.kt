package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity

@Entity(tableName = "Languages", primaryKeys = ["iso_639_1"])
data class Languages(
    val iso_639_1: String,
    val english_name: String,
    val name: String
)