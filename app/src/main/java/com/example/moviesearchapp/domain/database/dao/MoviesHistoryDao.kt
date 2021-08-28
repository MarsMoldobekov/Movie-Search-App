package com.example.moviesearchapp.domain.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.moviesearchapp.domain.database.entities.*

@Dao
interface MoviesHistoryDao {
    @Transaction
    @Query(value = "SELECT * FROM Movies")
    fun loadAllMoviesFullInformation(): List<MovieFullInformation>

    @Query(value = "INSERT INTO MoviesGenres(movie_id, genre_id) VALUES(:movieID, :genreID)")
    fun insertMoviesGenres(movieID: Long, genreID: Long)

    @Query(value = "INSERT INTO MoviesCountries(movie_id, iso_3166_1) VALUES(:movieID, :iso31661)")
    fun insertMoviesCountries(movieID: Long, iso31661: String)

    @Query(value = "INSERT INTO MoviesProductionCompanies(movie_id, production_company_id) VALUES(:movieID, :productionCompanyID)")
    fun insertMoviesProductionCompanies(movieID: Long, productionCompanyID: Long)

    @Query(value = "INSERT INTO MoviesLanguages(movie_id, iso_639_1) VALUES(:movieID, :iso6391)")
    fun insertMoviesLanguages(movieID: Long, iso6391: String)

    @Insert(entity = Genres::class)
    fun insertGenres(genres: List<Genres>)

    @Insert(entity = Countries::class)
    fun insertCountries(genres: List<Countries>)

    @Insert(entity = ProductionCompanies::class)
    fun insertProductionCompanies(genres: List<ProductionCompanies>)

    @Insert(entity = Languages::class)
    fun insertLanguages(languages: List<Languages>)

    @Insert(entity = Movies::class)
    fun insertMovie(movie: Movies)
}