package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.*

@Entity(
    tableName = "Movies",
    primaryKeys = ["id"],
    foreignKeys = [ForeignKey(
        entity = Statuses::class,
        parentColumns = ["status"],
        childColumns = ["status"],
        onDelete = RESTRICT,
        onUpdate = RESTRICT
    ), ForeignKey(
        entity = Languages::class,
        parentColumns = ["iso_639_1"],
        childColumns = ["original_language"],
        onDelete = CASCADE,
        onUpdate = CASCADE
    ), ForeignKey(
        entity = MoviesLanguages::class,
        parentColumns = ["movie"],
        childColumns = ["spoken_languages"],
        onDelete = CASCADE,
        onUpdate = NO_ACTION
    )]
)
data class Movies(
    val id: Long,
    val imdb_id: String,
    val homepage: String,
    //TODO(reason = add genres here)
    val budget: Int,
    //TODO(reason = add belongs_to_collection)
    val backdrop_path: String?,
    val adult: Boolean,
    val original_language: String,
    val original_title: String,
    val overview: String?,
    val popularity: Double,
    val poster_path: String?,
    val spoken_languages: Int,
    //TODO(reason = add production_companies here)
    //TODO(reason = add production_countries here)
    val release_date: String, //format: Date
    val revenue: Int,
    val runtime: Int?,
    val status: String,
    val tagline: String?,
    val title: String,
    val video: Boolean?,
    val vote_average: Double,
    val vote_count: Int
)
