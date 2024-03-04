package com.example.movieapp.presentation.screen.details_screen

import androidx.compose.runtime.Immutable
import com.example.movieapp.presentation.models.movie_info.MovieInfoUiModel

@Immutable
sealed class DetailsScreenUiState {

    @Immutable
    data class Success(
        val movieInfo: MovieInfoUiModel,
    ) : DetailsScreenUiState()

    data object Loading : DetailsScreenUiState()

    data class Error(
        val massage: String,
    ) : DetailsScreenUiState()
}