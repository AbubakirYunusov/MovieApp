package com.example.movieapp.data.repository

import com.example.movieapp.data.base.BaseDataSource
import com.example.movieapp.data.base.model.ResultStatus
import com.example.movieapp.data.mappers.movie.toDomain
import com.example.movieapp.data.mappers.movie_info.toDomain
import com.example.movieapp.data.remote.MovieService
import com.example.movieapp.domain.models.movie.MovieDomainModel
import com.example.movieapp.domain.models.movie_info.MovieInfoDomainModel
import com.example.movieapp.domain.repository.GetCurrentMovieRepository

class DefaultGetCurrentMovieRepository(
    private val service: MovieService
) : GetCurrentMovieRepository, BaseDataSource() {
    override suspend fun getPopularMovie(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest { service.getPopularMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.results?.map { it.toDomain() },
        )
    }

    override suspend fun getNowPlayingMovie(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest { service.getNowPlayingMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.results?.map { it.toDomain() },
        )
    }

    override suspend fun getUpcomingMovie(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest { service.getUpcomingMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.results?.map { it.toDomain() },
        )
    }

    override suspend fun getTopRatedMovie(): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest { service.getTopRatedMovie() }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.results?.map { it.toDomain() },
        )
    }

    override suspend fun getMovieInfo(movieid: Int): ResultStatus<MovieInfoDomainModel> {
        val response = invokeResponseRequest { service.getMovieInfo(movieId = movieid) }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.toDomain()
        )
    }

    override suspend fun searchByTitle(textQuery: String): ResultStatus<List<MovieDomainModel>> {
        val response = invokeResponseRequest {
            service.searchByQuery(textQuery = textQuery)
        }
        return ResultStatus(
            status = response.status,
            errorThrowable = response.errorThrowable,
            data = response.data?.results?.map { it.toDomain() }
        )
    }
}