package com.example.movieapp.data.models.movie_info

import com.google.gson.annotations.SerializedName

data class BelongsToCollectionDataModel(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("poster_path")
    val posterPath: String
)