package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Statuses", primaryKeys = ["status"])
data class Statuses(
    val status: String
)