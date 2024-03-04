package com.example.movieapp.data.mappers.movie_info

import com.example.movieapp.domain.models.movie_info.BelongsToCollectionDomainModel
import com.example.movieapp.domain.models.movie_info.GenreDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoResponseDetailsDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel
import com.example.movieapp.domain.models.movie_info.ProductionCompanyDomainModel
import com.example.movieapp.domain.models.movie_info.ProductionCountryDomainModel
import com.example.movieapp.domain.models.movie_info.SpokenLanguageDomainModel
import com.example.movieapp.presentation.models.movie_info.BelongsToCollectionUiModel
import com.example.movieapp.presentation.models.movie_info.GenreUiModel
import com.example.movieapp.presentation.models.movie_info.MovieInfoResponseDetailsUiModel
import com.example.movieapp.presentation.models.movie_info.MovieInfoUiModel
import com.example.movieapp.presentation.models.movie_info.ProductionCompanyUiModel
import com.example.movieapp.presentation.models.movie_info.ProductionCountryUiModel
import com.example.movieapp.presentation.models.movie_info.SpokenLanguageUiModel

fun MovieInfoDomainModel.toUi() = MovieInfoUiModel(
    backdropPath = backdropPath,
    budget = budget,
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    overview = overview,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    status = status,
    title = title,
    tagline = tagline,
    voteCount = voteCount,
    video = video,
    voteAverage = voteAverage,
    genres = genres.map { it.toUi() },
    spokenLanguages = spokenLanguages.map { it.toUi() },
//    adult = adult,
//    belongsToCollection = belongsToCollection.toUi(),
//    productionCompanies = productionCompanies.map { it.toUi() },
//    productionCountries = productionCountries.map { it.toUi() },
)

fun BelongsToCollectionDomainModel.toUi() = BelongsToCollectionUiModel(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)

fun GenreDomainModel.toUi() = GenreUiModel(
    id = id,
    name = name,
)

fun ProductionCompanyDomainModel.toUi() = ProductionCompanyUiModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)

fun ProductionCountryDomainModel.toUi() = ProductionCountryUiModel(
    iso31661 = iso31661,
    name = name,
)

fun SpokenLanguageDomainModel.toUi() = SpokenLanguageUiModel(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)

fun MovieInfoResponseDetailsDomainModel.toUi() = MovieInfoResponseDetailsUiModel(
    results = results.map { it.toUi() }
)