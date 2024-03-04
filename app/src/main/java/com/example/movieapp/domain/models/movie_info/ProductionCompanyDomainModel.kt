package com.example.movieapp.domain.models.movie_info

data class ProductionCompanyDomainModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
)