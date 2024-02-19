package com.example.movieapp.presentation.navigation

import android.annotation.SuppressLint
import com.example.movieapp.R

@SuppressLint("SupportAnnotationUsage")
sealed class Screens( val route: String) {

    data object SplashScreen : Screens(R.string.route_splash_screen.toString())

    data object HomeScreen : Screens(R.string.route_home_screen.toString())

    data object SearchScreen : Screens(R.string.route_search_screen.toString())

    data object WatchListScreen : Screens(R.string.route_watch_list_screen.toString())

    data object DetailsScreen : Screens(R.string.route_details_screen.toString())
}