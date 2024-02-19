package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.screen.home_screen.HomeScreen
import com.example.movieapp.presentation.screen.home_screen.HomeScreenViewModel
import com.example.movieapp.presentation.screen.splash_screen.SplashScreen

@Composable
fun MovieNavigation() {

    val navController = rememberNavController()
    val splashScreenRoute = Screens.SplashScreen.route
    val homeScreenRoute = Screens.HomeScreen.route
    val searchScreenRoute = Screens.SearchScreen.route
    val watchListScreenRoute = Screens.WatchListScreen.route
    val detailsScreenRoute = Screens.DetailsScreen.route

    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val viewModel: HomeScreenViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = splashScreenRoute,
    ) {

        composable(splashScreenRoute) {
            SplashScreen(callbackScreen = { navController.navigate(homeScreenRoute) })
        }
        composable(homeScreenRoute) {
            HomeScreen(
                homeScreenViewModel = homeScreenViewModel,
                uiState = viewModel.uiState.collectAsState().value
            )
        }
    }
}