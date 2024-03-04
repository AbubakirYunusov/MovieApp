package com.example.movieapp.domain.use_cases.movie_search

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class DefaultSearchMovie(
    private val repository: GetCurrentMovieRepository
) : SearchMovieUseCase {
    override suspend fun invoke(textQuery: String): ResultStatus<List<MovieDomainModel>> =
        repository.searchByTitle(textQuery = textQuery)

}