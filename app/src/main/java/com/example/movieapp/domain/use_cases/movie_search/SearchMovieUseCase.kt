package com.example.movieapp.domain.use_cases.movie_search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel

interface SearchMovieUseCase {
    suspend operator fun invoke(
        textQuery: String
    ) : ResultStatus<List<MovieDomainModel>>
}