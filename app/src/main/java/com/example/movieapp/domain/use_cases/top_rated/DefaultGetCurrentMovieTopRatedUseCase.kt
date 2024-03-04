package com.example.movieapp.domain.use_cases.top_rated

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import javax.inject.Inject

class DefaultGetCurrentMovieTopRatedUseCase @Inject constructor(
    private val repository: GetCurrentMovieRepository
) : GetCurrentMovieTopRatedUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> {
        return repository.getTopRatedMovie()
    }
}