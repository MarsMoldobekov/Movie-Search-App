package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Genres", primaryKeys = ["id"])
data class Genres(
    val id: Int,
    val name: String
)