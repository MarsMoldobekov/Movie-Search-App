package com.example.moviesearchapp.domain.database.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MovieFullInformation(
    @Embedded val movie: Movies,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "genre_id",
        associateBy = Junction(MoviesGenresCrossRef::class)
    )
    val genres: List<Genres>,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "production_company_id",
        associateBy = Junction(MoviesProductionCompaniesCrossRef::class)
    )
    val productionCompanies: List<ProductionCompanies>,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "iso_3166_1",
        associateBy = Junction(MoviesCountriesCrossRef::class)
    )
    val countries: List<Countries>,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "iso_639_1",
        associateBy = Junction(MoviesLanguagesCrossRef::class)
    )
    val languages: List<Languages>
)