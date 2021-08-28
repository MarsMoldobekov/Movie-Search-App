package com.example.moviesearchapp

import android.app.Application
import androidx.room.Room
import com.example.moviesearchapp.domain.database.MoviesHistoryDatabase
import com.example.moviesearchapp.domain.database.dao.MoviesHistoryDao

class App : Application() {
    companion object {
        private var appInstance: App? = null
        private var database: MoviesHistoryDatabase? = null
        private const val DATABASE_NAME: String = "MoviesHistoryDatabase.db"

        fun getMoviesHistoryDao(): MoviesHistoryDao {
            if (database == null) {
                if (appInstance == null) {
                    throw IllegalStateException("Application is null while creating DataBase")
                }

                database = Room.databaseBuilder(
                    appInstance!!.applicationContext,
                    MoviesHistoryDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }

            return database!!.moviesHistoryDao()
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}