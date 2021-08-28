package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "MoviesCountries", primaryKeys = ["movie_id", "iso_3166_1"])
data class MoviesCountriesCrossRef(
        @ColumnInfo(name = "movie_id") val movieID: Long,
        @ColumnInfo(name = "iso_3166_1") val iso31661: String
)