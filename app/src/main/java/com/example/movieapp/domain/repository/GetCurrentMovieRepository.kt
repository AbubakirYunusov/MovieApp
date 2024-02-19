package com.example.movieapp.domain.repository

import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.domain.models.MovieDomainModel

interface GetCurrentMovieRepository {

    suspend fun getPopularMovie(): ResultStatus<List<MovieDomainModel>>

    suspend fun getNowPlayingMovie(): ResultStatus<List<MovieDomainModel>>

    suspend fun getUpcomingMovie(): ResultStatus<List<MovieDomainModel>>

    suspend fun getTopRatedMovie(): ResultStatus<List<MovieDomainModel>>
}