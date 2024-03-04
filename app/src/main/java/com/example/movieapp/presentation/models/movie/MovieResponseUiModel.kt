package com.example.movieapp.presentation.models.movie

import java.io.Serializable

data class MovieResponseUiModel(
    val results: List<MovieUiModel>
) : Serializable {
    companion object {
        val unknown = MovieResponseUiModel(
            results = emptyList()
        )
    }
}