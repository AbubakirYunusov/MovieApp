package com.example.movieapp.domain.models.movie

import java.io.Serializable

data class MovieResponseDomainModel(
    val results: List<MovieDomainModel>
) : Serializable  {
    companion object {
        val unknown =  MovieResponseDomainModel (
            results = emptyList()
        )
    }
}