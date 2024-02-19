package com.example.movieapp.domain.use_cases.now_playing

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.MovieDomainModel

interface GetCurrentMovieNowPlayingUseCase {

    suspend operator fun invoke(): ResultStatus<List<MovieDomainModel>>
}