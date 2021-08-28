package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Languages", primaryKeys = ["iso_639_1"])
data class Languages(
    @ColumnInfo(name = "iso_639_1") val iso6391: String,
    @ColumnInfo(name = "english_name") val englishName: String,
    val name: String
)