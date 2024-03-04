package com.example.movieapp.domain.use_cases.upcoming

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel

interface GetCurrentMovieUpcomingUseCase {
    suspend operator fun invoke(): ResultStatus<List<MovieDomainModel>>
}