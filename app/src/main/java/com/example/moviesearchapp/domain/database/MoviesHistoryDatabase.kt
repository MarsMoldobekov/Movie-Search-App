package com.example.moviesearchapp.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesearchapp.domain.database.dao.MoviesHistoryDao
import com.example.moviesearchapp.domain.database.entities.*

@Database(
    entities = [
        Movies::class,
        Genres::class,
        Countries::class,
        Languages::class,
        ProductionCompanies::class,
        MoviesCountriesCrossRef::class,
        MoviesGenresCrossRef::class,
        MoviesLanguagesCrossRef::class,
        MoviesProductionCompaniesCrossRef::class
    ],
    version = 1
)
abstract class MoviesHistoryDatabase : RoomDatabase() {
    abstract fun moviesHistoryDao(): MoviesHistoryDao
}