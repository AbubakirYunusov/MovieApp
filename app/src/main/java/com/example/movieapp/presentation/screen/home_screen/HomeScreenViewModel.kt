package com.example.movieapp.presentation.screen.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.toUi
import com.example.movieapp.domain.use_cases.now_playing.GetCurrentMovieNowPlayingUseCase
import com.example.movieapp.domain.use_cases.popular.GetCurrentMoviePopularUseCase
import com.example.movieapp.domain.use_cases.top_rated.GetCurrentMovieTopRatedUseCase
import com.example.movieapp.domain.use_cases.upcoming.GetCurrentMovieUpcomingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getCurrentMoviePopularUseCase: GetCurrentMoviePopularUseCase,
    private val getCurrentMovieNowPlayingUseCase: GetCurrentMovieNowPlayingUseCase,
    private val getCurrentMovieUpcomingUseCase: GetCurrentMovieUpcomingUseCase,
    private val getCurrentMovieTopRatedUseCase: GetCurrentMovieTopRatedUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeScreenUiState> =
        MutableStateFlow(HomeScreenUiState.Loading)
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    private val handle = CoroutineExceptionHandler { _, throwable -> }

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch(handle + Dispatchers.IO) {
            val popularResponse = getCurrentMoviePopularUseCase()
            val upcomingUseCase = getCurrentMovieUpcomingUseCase()
            val nowPLayingResponse = getCurrentMovieNowPlayingUseCase()
            val topRatedResponse = getCurrentMovieTopRatedUseCase()

            if (
                popularResponse.status == ResponseStatus.SUCCESS &&
                topRatedResponse.status == ResponseStatus.SUCCESS &&
                upcomingUseCase.status == ResponseStatus.SUCCESS &&
                nowPLayingResponse.status == ResponseStatus.SUCCESS
            ) {
                popularResponse.data?.let { popularMovies ->
                    upcomingUseCase.data?.let { upcomingMovies ->
                        topRatedResponse.data?.let { topRatedMovies ->
                            nowPLayingResponse.data?.let { nowPlayingMovies ->
                                _uiState.update {
                                    HomeScreenUiState.Success(
                                        moviePopular = popularMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        movieUpcoming = upcomingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        movieTopRated = topRatedMovies.map { it.toUi() }
                                            .toImmutableList(),
                                        movieNowPlaying = nowPlayingMovies.map { it.toUi() }
                                            .toImmutableList(),
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}