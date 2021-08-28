package com.example.moviesearchapp.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

//TODO(reason = add belongs_to_collection column)
//TODO(reason = add reference for original_language)
//TODO(reason = add status column)
@Entity(tableName = "Movies", primaryKeys = ["movie_id"])
data class Movies(
    @ColumnInfo(name = "movie_id") val movieID: Long,
    @ColumnInfo(name = "imdb_id") val imdbID: String,
    val homepage: String,
    val budget: Int,
    @ColumnInfo(name = "backdrop_path") val backdropPath: String?,
    val adult: Boolean,
    @ColumnInfo(name = "original_language") val originalLanguage: String,
    @ColumnInfo(name = "original_title") val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    @ColumnInfo(name = "poster_path") val posterPath: String?,
    @ColumnInfo(name = "release_date") val releaseDate: String, //format: Date
    val revenue: Int,
    val runtime: Int?,
    val tagline: String?,
    val title: String,
    val video: Boolean?,
    @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @ColumnInfo(name = "vote_count") val voteCount: Int
)