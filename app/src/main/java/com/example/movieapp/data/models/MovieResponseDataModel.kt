package com.example.movieapp.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponseDataModel(
    @SerializedName("results")
    val results: List<MovieDataModel>
) : Serializable  {
    val unknown =  MovieResponseDataModel (
        results = emptyList()
    )
}