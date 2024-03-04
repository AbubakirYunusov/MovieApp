package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel

interface GetCurrentMovieRepository {
    suspend fun getPopularMovie(): ResultStatus<List<MovieDomainModel>>
    suspend fun getNowPlayingMovie(): ResultStatus<List<MovieDomainModel>>
    suspend fun getUpcomingMovie(): ResultStatus<List<MovieDomainModel>>
    suspend fun getTopRatedMovie(): ResultStatus<List<MovieDomainModel>>
    suspend fun getMovieInfo(movieId: Int): ResultStatus<MovieInfoDomainModel>
    suspend fun searchByTitle(textQuery: String) : ResultStatus<List<MovieDomainModel>>
}