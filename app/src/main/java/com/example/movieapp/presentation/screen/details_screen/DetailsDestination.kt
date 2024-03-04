package com.example.movieapp.presentation.screen.details_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieapp.presentation.navigation.Destination

object DetailsDestination : Destination {
    override val route: String
        get() = "details_screen"

    val movieId = "movieId"

    val routeWithArgs = "$route/{$movieId}"

    val arguments = listOf(
        navArgument(movieId) { type = NavType.IntType }
    )
}