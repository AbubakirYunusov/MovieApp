package com.example.movieapp.domain.use_cases.popular

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import javax.inject.Inject

class DefaultGetCurrentMoviePopularUseCase @Inject constructor(
    private val repository: GetCurrentMovieRepository
) : GetCurrentMoviePopularUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> {
        return repository.getPopularMovie()
    }
}