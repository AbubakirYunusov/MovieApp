package com.example.movieapp.presentation.screen.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.base.model.ResponseStatus
import com.example.movieapp.data.mappers.movie_info.toUi
import com.example.movieapp.domain.use_cases.movie_info.GetMovieInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val getMovieInfoUseCase: GetMovieInfoUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<DetailsScreenUiState> =
        MutableStateFlow(DetailsScreenUiState.Loading)
    val uiState: StateFlow<DetailsScreenUiState> = _uiState.asStateFlow()

    fun fetchMovieInfo(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val movieInfoResponse = getMovieInfoUseCase(movieId = movieId)

            if (movieInfoResponse.status == ResponseStatus.SUCCESS) {
                movieInfoResponse.data?.let { infoMovies ->
                    _uiState.update {
                        DetailsScreenUiState.Success(
                            movieInfo = infoMovies.toUi()
                        )
                    }
                }
            }
        }
    }
}