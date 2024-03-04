package com.example.movieapp.data.mappers.movie

import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.models.movie.MovieResponseDomainModel
import com.example.movieapp.presentation.models.movie.MovieUiModel
import com.example.movieapp.presentation.models.movie.MovieResponseUiModel

fun MovieDomainModel.toUi() = MovieUiModel(
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

fun MovieResponseDomainModel.toUi() = MovieResponseUiModel(
    results = results.map { it.toUi() }
)