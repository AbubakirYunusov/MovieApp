package com.example.movieapp.di

import com.example.movieapp.domain.repository.GetCurrentMovieRepository
import com.example.movieapp.domain.use_cases.movie_info.DefaultGetMovieInfoUseCase
import com.example.movieapp.domain.use_cases.movie_info.GetMovieInfoUseCase
import com.example.movieapp.domain.use_cases.now_playing.DefaultGetCurrentMovieNowPlayingUseCase
import com.example.movieapp.domain.use_cases.now_playing.GetCurrentMovieNowPlayingUseCase
import com.example.movieapp.domain.use_cases.popular.DefaultGetCurrentMoviePopularUseCase
import com.example.movieapp.domain.use_cases.popular.GetCurrentMoviePopularUseCase
import com.example.movieapp.domain.use_cases.top_rated.DefaultGetCurrentMovieTopRatedUseCase
import com.example.movieapp.domain.use_cases.top_rated.GetCurrentMovieTopRatedUseCase
import com.example.movieapp.domain.use_cases.upcoming.DefaultGetCurrentMovieUpcomingUseCase
import com.example.movieapp.domain.use_cases.upcoming.GetCurrentMovieUpcomingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun providesGetCurrentMoviePopularUseCase(
        repository: GetCurrentMovieRepository
    ): GetCurrentMoviePopularUseCase = DefaultGetCurrentMoviePopularUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieNowPlayingUseCase(
        repository: GetCurrentMovieRepository
    ): GetCurrentMovieNowPlayingUseCase = DefaultGetCurrentMovieNowPlayingUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieUpcomingUseCase(
        repository: GetCurrentMovieRepository
    ): GetCurrentMovieUpcomingUseCase = DefaultGetCurrentMovieUpcomingUseCase(
        repository = repository
    )

    @Provides
    fun providesGetCurrentMovieTopRatedUseCase(
        repository: GetCurrentMovieRepository
    ): GetCurrentMovieTopRatedUseCase = DefaultGetCurrentMovieTopRatedUseCase(
        repository = repository
    )

    @Provides
    fun providesGetMovieInfoUseCase(
        repository: GetCurrentMovieRepository
    ): GetMovieInfoUseCase = DefaultGetMovieInfoUseCase(
        repository = repository
    )
}