package com.example.movieapp.data.models.movie_info

import com.google.gson.annotations.SerializedName

data class ProductionCountryDataModel(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("name")
    val name: String
)