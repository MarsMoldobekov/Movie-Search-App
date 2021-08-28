package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "ProductionCompanies", primaryKeys = ["production_company_id"])
data class ProductionCompanies(
    @ColumnInfo(name = "production_company_id") val productionCompanyID: Long,
    val name: String,
    @ColumnInfo(name = "logo_path") val logoPath: String?,
    @ColumnInfo(name = "original_country") val originalCountry: String
)