package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Countries", primaryKeys = ["iso_3166_1"])
data class Countries(
    @ColumnInfo(name = "iso_3166_1") val iso31661: String,
    @ColumnInfo(name = "english_name") val englishName: String
)