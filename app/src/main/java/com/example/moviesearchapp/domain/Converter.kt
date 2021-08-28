package com.example.moviesearchapp.domain

import com.example.moviesearchapp.domain.database.entities.Countries
import com.example.moviesearchapp.domain.database.entities.Genres
import com.example.moviesearchapp.domain.database.entities.Languages
import com.example.moviesearchapp.domain.net.data.Country
import com.example.moviesearchapp.domain.net.data.Genre
import com.example.moviesearchapp.domain.net.data.Language

class Converter {
    @JvmName("convertGenre")
    fun convert(genres: List<Genre>): List<Genres> = genres.map {
        Genres(genreID = it.id, name = it.name)
    }

    @JvmName("convertCountry")
    fun convert(countries: List<Country>): List<Countries> = countries.map {
        Countries(iso31661 = it.iso_3166_1, englishName = it.english_name)
    }

    @JvmName("convertLanguage")
    fun convert(languages: List<Language>): List<Languages> = languages.map {
        Languages(iso6391 = it.iso_639_1, englishName = it.english_name, name = it.name)
    }
}