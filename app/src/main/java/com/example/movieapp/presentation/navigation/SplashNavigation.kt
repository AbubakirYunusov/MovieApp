package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movieapp.presentation.screen.splash_screen.SplashDestination
import com.example.movieapp.presentation.screen.splash_screen.SplashScreen

@Composable
fun SplashNavigation(
    navController: NavHostController,
    callBack: () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = SplashDestination.route,
    ) {
        composable(SplashDestination.route) {
            SplashScreen(callbackScreen = { navController.navigate(Screens.BottomNavGraph.route) })
        }

        composable(Screens.BottomNavGraph.route) {
            MainScreenBottomNavGraph(callBack = callBack)
        }
    }
}