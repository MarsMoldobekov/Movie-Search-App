package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "MoviesGenres", primaryKeys = ["movie_id", "genre_id"])
data class MoviesGenresCrossRef(
        @ColumnInfo(name = "movie_id") val movieID: Long,
        @ColumnInfo(name = "genre_id") val genreID: Long
)