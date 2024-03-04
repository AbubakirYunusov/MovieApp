package com.example.movieapp.domain.use_cases.movie_info

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import javax.inject.Inject

class DefaultGetMovieInfoUseCase @Inject constructor(
    private val repository: GetCurrentMovieRepository
) : GetMovieInfoUseCase {
    override suspend fun invoke(movieId: Int): ResultStatus<MovieInfoDomainModel> {
        return repository.getMovieInfo(movieId = movieId)
    }
}