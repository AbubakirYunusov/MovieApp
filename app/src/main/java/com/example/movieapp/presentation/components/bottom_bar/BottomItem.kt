package com.example.movieapp.presentation.components.bottom_bar

import com.example.movieapp.R

sealed class BottomItem(
    val title: String,
    val iconId: Int,
    val route: String,
) {
    data object HomeScreen : BottomItem(
        "Home",
        R.drawable.home,
        "HomeScreen"
    )
    data object SearchScreen : BottomItem(
        "Search",
        R.drawable.search,
        "SearchScreen"
    )
    data object WatchListScreen : BottomItem(
        "Watch list",
        R.drawable.path,
        "WatchListScreen"
    )
}