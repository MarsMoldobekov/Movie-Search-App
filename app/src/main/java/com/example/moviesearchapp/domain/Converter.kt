package com.example.moviesearchapp.domain

import com.example.moviesearchapp.domain.database.entities.*
import com.example.moviesearchapp.domain.net.data.*

class Converter {
    @JvmName(name = "convertGenre")
    fun convert(genres: List<Genre>): List<Genres> = genres.map {
        Genres(genreID = it.id, name = it.name)
    }

    @JvmName(name = "convertCountry")
    fun convert(countries: List<Country>): List<Countries> = countries.map {
        Countries(iso31661 = it.iso_3166_1, englishName = it.english_name)
    }

    @JvmName(name = "convertLanguage")
    fun convert(languages: List<Language>): List<Languages> = languages.map {
        Languages(iso6391 = it.iso_639_1, englishName = it.english_name, name = it.name)
    }

    @JvmName(name = "convertCompanies")
    fun convert(productionCompanies: List<ProductionCompany>): List<ProductionCompanies> =
        productionCompanies.map {
            ProductionCompanies(
                productionCompanyID = it.id,
                name = it.name,
                logoPath = it.logoPath,
                originalCountry = it.originCountry
            )
        }

    @JvmName(name = "convertMovies")
    fun convert(movieDetails: MovieDetails): Movies = Movies(
        movieID = movieDetails.id,
        imdbID = movieDetails.imdbId,
        homepage = movieDetails.homepage,
        budget = movieDetails.budget,
        backdropPath = movieDetails.backdropPath,
        adult = movieDetails.adult,
        originalLanguage = movieDetails.originalLanguage,
        originalTitle = movieDetails.originalTitle,
        overview = movieDetails.overview,
        popularity = movieDetails.popularity,
        posterPath = movieDetails.posterPath,
        releaseDate = movieDetails.releaseDate,
        revenue = movieDetails.revenue,
        runtime = movieDetails.runtime,
        tagline = movieDetails.tagline,
        title = movieDetails.title,
        video = movieDetails.video,
        voteAverage = movieDetails.voteAverage,
        voteCount = movieDetails.voteCount
    )
}