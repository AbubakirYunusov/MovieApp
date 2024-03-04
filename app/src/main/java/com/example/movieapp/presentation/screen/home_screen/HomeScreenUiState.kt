package com.example.movieapp.presentation.screen.home_screen

import androidx.compose.runtime.Immutable
import com.example.movieapp.presentation.models.movie.MovieUiModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeScreenUiState {
    @Immutable
    data class Success(
        val moviePopular: ImmutableList<MovieUiModel>,
        val movieTopRated: ImmutableList<MovieUiModel>,
        val movieUpcoming: ImmutableList<MovieUiModel>,
        val movieNowPlaying: ImmutableList<MovieUiModel>,
    ) : HomeScreenUiState()

    data object Loading : HomeScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
    ) : HomeScreenUiState()
}