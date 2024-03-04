package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.presentation.components.bottom_bar.BottomItem
import com.example.movieapp.presentation.screen.details_screen.DetailsDestination
import com.example.movieapp.presentation.screen.details_screen.DetailsScreen
import com.example.movieapp.presentation.screen.details_screen.DetailsScreenViewModel
import com.example.movieapp.presentation.screen.home_screen.HomeScreenViewModel
import com.example.movieapp.presentation.screen.home_screen.HomeScreens
import com.example.movieapp.presentation.screen.search_screen.SearchScreen
import com.example.movieapp.presentation.screen.watch_list_screen.WatchListScreen

@Composable
fun MovieNavigation(
    navController: NavHostController,
    callBack: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = BottomItem.HomeScreen.route,
    ) {
        composable(BottomItem.HomeScreen.route) {
            val viewModel: HomeScreenViewModel = hiltViewModel()
            HomeScreens(
                viewModel = viewModel,
                onNavigateToInfo = { movieId ->
                    navController.navigate("${DetailsDestination.route}/$movieId")
                },
                callBack = callBack,
                uiState = viewModel.uiState,
                onNavigateBlockToInfo = {movieId ->
                    navController.navigate("${DetailsDestination.route}/$movieId")
                },
            )
        }
        composable(
            route = DetailsDestination.routeWithArgs,
            arguments = DetailsDestination.arguments,
        ) { navBackStackEntry ->
            val movieId = navBackStackEntry.arguments?.getInt(DetailsDestination.movieId) ?: 0
            val viewModel: DetailsScreenViewModel = hiltViewModel()
            DetailsScreen(
                uiState = viewModel.uiState.collectAsState().value,
                viewModel = viewModel,
                onGetMovieInfo = {
                    viewModel.fetchMovieInfo(
                        movieId = movieId
                    )
                },
                callBackPopBackDetail = { navController.popBackStack() }
            )
        }
        composable(BottomItem.SearchScreen.route) {
            SearchScreen(callBackPopBackSearch = {navController.popBackStack()})
        }
        composable(BottomItem.WatchListScreen.route) {
            WatchListScreen(callBackPopBackSearch = {navController.popBackStack()})
        }
    }
}