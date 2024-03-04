package com.example.movieapp.data.remote

import com.example.movieapp.data.models.movie.MovieResponseDataModel
import com.example.movieapp.data.models.movie_info.MovieInfoDataModel
import com.example.movieapp.data.utils.Constants.FETCH_MOVIE_INFO
import com.example.movieapp.data.utils.Constants.FETCH_NOW_PLAYING_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_POPULAR_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_TOP_RATED_MOVIE
import com.example.movieapp.data.utils.Constants.FETCH_UPCOMING_MOVIE
import com.example.movieapp.data.utils.Constants.GET_MOVIE_SEARCH_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET(FETCH_POPULAR_MOVIE)
    suspend fun getPopularMovie(
        @Query("language") language: String = "en",
    ): Response<MovieResponseDataModel>

    @GET(FETCH_MOVIE_INFO)
    suspend fun getMovieInfo(
        @Path("movie_id") movieId: Int
    ): Response<MovieInfoDataModel>

    @GET(GET_MOVIE_SEARCH_ID)
    suspend fun searchByQuery(
        @Query("query") textQuery: String,
    ): Response<MovieResponseDataModel>

    @GET(FETCH_NOW_PLAYING_MOVIE)
    suspend fun getNowPlayingMovie(
        @Query("language") language: String = "en",
    ): Response<MovieResponseDataModel>

    @GET(FETCH_UPCOMING_MOVIE)
    suspend fun getUpcomingMovie(
        @Query("language") language: String = "en",
    ): Response<MovieResponseDataModel>

    @GET(FETCH_TOP_RATED_MOVIE)
    suspend fun getTopRatedMovie(
        @Query("language") language: String = "en",
    ): Response<MovieResponseDataModel>

}