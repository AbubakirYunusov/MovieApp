package com.example.movieapp.domain.use_cases.now_playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import javax.inject.Inject

class DefaultGetCurrentMovieNowPlayingUseCase @Inject constructor(
    private val repository: GetCurrentMovieRepository
) : GetCurrentMovieNowPlayingUseCase {
    override suspend fun invoke(): ResultStatus<List<MovieDomainModel>> {
        return repository.getNowPlayingMovie()
    }
}