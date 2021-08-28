package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "MoviesLanguages", primaryKeys = ["movie_id", "iso_639_1"])
data class MoviesLanguagesCrossRef(
    @ColumnInfo(name = "movie_id") val movieID: Long,
    @ColumnInfo(name = "iso_639_1") val iso6391: String,
)