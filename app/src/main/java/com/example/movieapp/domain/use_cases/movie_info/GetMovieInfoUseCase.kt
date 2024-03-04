package com.example.movieapp.domain.use_cases.movie_info

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel

interface GetMovieInfoUseCase {
    suspend operator fun invoke(movieId: Int): ResultStatus<MovieInfoDomainModel>
}