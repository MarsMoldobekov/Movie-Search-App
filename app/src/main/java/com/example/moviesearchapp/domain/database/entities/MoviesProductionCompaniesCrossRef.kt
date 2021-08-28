package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "MoviesProductionCompanies", primaryKeys = ["movie_id", "production_company_id"])
data class MoviesProductionCompaniesCrossRef(
    @ColumnInfo(name = "movie_id") val movieID: Long,
    @ColumnInfo(name = "production_company_id") val productionCompanyID: Long
)