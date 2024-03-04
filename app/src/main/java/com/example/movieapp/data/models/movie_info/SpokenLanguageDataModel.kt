package com.example.movieapp.data.models.movie_info

import com.google.gson.annotations.SerializedName

data class SpokenLanguageDataModel(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    @SerializedName("name")
    val name: String
)