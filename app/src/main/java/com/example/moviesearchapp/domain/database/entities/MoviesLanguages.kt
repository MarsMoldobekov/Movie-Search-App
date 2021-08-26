package com.example.moviesearchapp.domain.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.RESTRICT
import androidx.room.PrimaryKey

//TODO(reason = rename this class if there is more opportune name)
/**
 * Table "Movies" has a column "spoken_languages", which must contains an array of languages,
 * described in "Languages" table.
 * For this reason "MoviesLanguages" was created. It contains "language" and "movie".
 * The first references to "iso_639_1" in "Languages" table,
 * while "spoken_languages" in "Movies" table references to the second.
 */
@Entity(
    tableName = "MoviesLanguages",
    foreignKeys = [ForeignKey(
        entity = Languages::class,
        parentColumns = ["iso_639_1"],
        childColumns = ["language"],
        onDelete = RESTRICT,
        onUpdate = RESTRICT
    )]
)
data class MoviesLanguages(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val language: String,
    val movie: Int
)
