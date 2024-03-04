package com.example.movieapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.presentation.components.bottom_bar.BottomNavGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenBottomNavGraph(
    callBack: () -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavGraph(
                navController = navController,
            )
        }
    ) {
        MovieNavigation(
            navController = navController,
            callBack = callBack
        )
    }
}