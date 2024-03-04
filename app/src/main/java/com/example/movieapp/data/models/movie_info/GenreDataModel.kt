package com.example.movieapp.data.models.movie_info

import com.google.gson.annotations.SerializedName

data class GenreDataModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)