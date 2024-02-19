package com.example.movieapp.domain.use_cases.upcoming

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.MovieDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import javax.inject.Inject

class DefaultGetCurrentMovieUpcomingUseCase @Inject constructor(
    private val repository: GetCurrentMovieRepository
) : GetCurrentMovieUpcomingUseCase {

    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> {
        return repository.getUpcomingMovie()
    }
}