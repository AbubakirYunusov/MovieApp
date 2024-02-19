package com.example.movieapp.data.mappers

import com.example.movieapp.data.models.MovieDataModel
import com.example.movieapp.data.models.MovieResponseDataModel
import com.example.movieapp.domain.models.MovieDomainModel
import com.example.movieapp.domain.models.MovieResponseDomainModel

fun MovieDataModel.toDomain() = MovieDomainModel(
    backdropPath = backdropPath,
    genreIds = genreIds,
    movieId = movieId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun MovieResponseDataModel.toDomain() = MovieResponseDomainModel(
    results = results.map { it.toDomain() }
)