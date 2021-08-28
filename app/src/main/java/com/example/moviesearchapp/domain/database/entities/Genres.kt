package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Genres", primaryKeys = ["genre_id"])
data class Genres(
        @ColumnInfo(name = "genre_id") val genreID: Long,
        val name: String
)