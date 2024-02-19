package com.example.movieapp.data.mappers

import com.example.movieapp.domain.models.MovieDomainModel
import com.example.movieapp.domain.models.MovieResponseDomainModel
import com.example.movieapp.presentation.models.MoviePresentationModel
import com.example.movieapp.presentation.models.MovieResponsePresentationModel

fun MovieDomainModel.toUi() = MoviePresentationModel(
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

fun MovieResponseDomainModel.toUi() = MovieResponsePresentationModel(
    results = results.map { it.toUi() }
)