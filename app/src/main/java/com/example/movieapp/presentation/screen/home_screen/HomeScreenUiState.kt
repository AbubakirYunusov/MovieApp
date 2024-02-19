package com.example.movieapp.presentation.screen.home_screen

import androidx.compose.runtime.Immutable
import com.example.movieapp.presentation.models.MoviePresentationModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeScreenUiState {
    @Immutable
    data class Success(
        val moviePopular: ImmutableList<MoviePresentationModel>,
        val movieTopRated: ImmutableList<MoviePresentationModel>,
        val movieUpcoming: ImmutableList<MoviePresentationModel>,
        val movieNowPlaying: ImmutableList<MoviePresentationModel>,
    ) : HomeScreenUiState()

    data object Loading : HomeScreenUiState()

    @Immutable
    data class Error(
        val massage: String,
    ) : HomeScreenUiState()
}