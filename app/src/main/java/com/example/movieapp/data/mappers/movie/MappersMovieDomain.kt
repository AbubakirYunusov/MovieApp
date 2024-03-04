package com.example.movieapp.data.mappers.movie

import com.example.movieapp.data.models.movie.MovieDataModel
import com.example.movieapp.data.models.movie.MovieResponseDataModel
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.models.movie.MovieResponseDomainModel

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