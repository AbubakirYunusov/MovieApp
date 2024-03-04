package com.example.movieapp.data.mappers.movie_info

import com.example.movieapp.data.models.movie_info.BelongsToCollectionDataModel
import com.example.movieapp.data.models.movie_info.GenreDataModel
import com.example.movieapp.data.models.movie_info.MovieInfoDataModel
import com.example.movieapp.data.models.movie_info.MovieInfoResponseDetailsDataModel
import com.example.movieapp.data.models.movie_info.ProductionCompanyDataModel
import com.example.movieapp.data.models.movie_info.ProductionCountryDataModel
import com.example.movieapp.data.models.movie_info.SpokenLanguageDataModel
import com.example.movieapp.domain.models.movie_info.BelongsToCollectionDomainModel
import com.example.movieapp.domain.models.movie_info.GenreDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoResponseDetailsDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel
import com.example.movieapp.domain.models.movie_info.ProductionCompanyDomainModel
import com.example.movieapp.domain.models.movie_info.ProductionCountryDomainModel
import com.example.movieapp.domain.models.movie_info.SpokenLanguageDomainModel

fun MovieInfoDataModel.toDomain() = MovieInfoDomainModel(
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
    genres = genres.map { it.toDomain() },
    spokenLanguages = spokenLanguages.map { it.toDomain() },
//    adult = adult,
//    belongsToCollection = belongsToCollection.toDomain(),
//    productionCompanies = productionCompanies.map { it.toDomain() },
//    productionCountries = productionCountries.map { it.toDomain() },
)

fun BelongsToCollectionDataModel.toDomain() = BelongsToCollectionDomainModel(
    backdropPath = backdropPath,
    id = id,
    name = name,
    posterPath = posterPath,
)

fun GenreDataModel.toDomain() = GenreDomainModel(
    id = id,
    name = name,
)

fun ProductionCompanyDataModel.toDomain() = ProductionCompanyDomainModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)

fun ProductionCountryDataModel.toDomain() = ProductionCountryDomainModel(
    iso31661 = iso31661,
    name = name,
)

fun SpokenLanguageDataModel.toDomain() = SpokenLanguageDomainModel(
    englishName = englishName,
    iso6391 = iso6391,
    name = name
)

fun MovieInfoResponseDetailsDataModel.toDomain() = MovieInfoResponseDetailsDomainModel(
    results = results.map { it.toDomain() }
)