package com.example.movieapp.domain.models.movie_info

data class MovieInfoDomainModel(
    val backdropPath: String,
    val budget: Int,
    val genres: List<GenreDomainModel>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageDomainModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
//    val adult: Boolean,
//    val belongsToCollection: BelongsToCollectionDomainModel,
//    val productionCompanies: List<ProductionCompanyDomainModel>,
//    val productionCountries: List<ProductionCountryDomainModel>,
)