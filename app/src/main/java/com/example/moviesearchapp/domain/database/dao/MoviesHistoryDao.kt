package com.example.moviesearchapp.domain.database.dao

import androidx.room.*
import com.example.moviesearchapp.domain.database.entities.*

@Dao
interface MoviesHistoryDao {
    @Transaction
    @Query(value = "SELECT * FROM Movies")
    suspend fun loadAllMoviesFullInformation(): List<MovieFullInformation>

    @Query(value = "INSERT INTO MoviesGenres(movie_id, genre_id) VALUES(:movieID, :genreID)")
    suspend fun insertMoviesGenres(movieID: Long, genreID: Long)

    @Query(value = "INSERT INTO MoviesCountries(movie_id, iso_3166_1) VALUES(:movieID, :iso31661)")
    suspend fun insertMoviesCountries(movieID: Long, iso31661: String)

    @Query(value = "INSERT INTO MoviesProductionCompanies(movie_id, production_company_id) VALUES(:movieID, :productionCompanyID)")
    suspend fun insertMoviesProductionCompanies(movieID: Long, productionCompanyID: Long)

    @Query(value = "INSERT INTO MoviesLanguages(movie_id, iso_639_1) VALUES(:movieID, :iso6391)")
    suspend fun insertMoviesLanguages(movieID: Long, iso6391: String)

    @Insert(entity = Genres::class)
    suspend fun insertGenres(genres: List<Genres>)

    @Insert(entity = Countries::class)
    suspend fun insertCountries(genres: List<Countries>)

    @Insert(entity = ProductionCompanies::class, onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductionCompanies(genres: List<ProductionCompanies>)

    @Insert(entity = Languages::class)
    suspend fun insertLanguages(languages: List<Languages>)

    @Insert(entity = Movies::class)
    suspend fun insertMovie(movie: Movies)
}