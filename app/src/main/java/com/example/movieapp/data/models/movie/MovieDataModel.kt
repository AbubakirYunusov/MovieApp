package com.example.movieapp.data.models.movie

import com.example.movieapp.data.utils.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDataModel(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
) : Serializable {
    companion object {
        val unknown = MovieDataModel (
            backdropPath = Constants.EMPTY_STRING,
            genreIds = listOf(0),
            movieId = 0,
            originalLanguage = Constants.EMPTY_STRING,
            originalTitle = Constants.EMPTY_STRING,
            overview = Constants.EMPTY_STRING,
            popularity = 0.0,
            posterPath = Constants.EMPTY_STRING,
            releaseDate = Constants.EMPTY_STRING,
            title = Constants.EMPTY_STRING,
            voteAverage = 0.0,
            voteCount = 0,
        )
    }
}