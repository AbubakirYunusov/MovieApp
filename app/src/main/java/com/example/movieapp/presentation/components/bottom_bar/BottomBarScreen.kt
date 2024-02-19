package com.example.movieapp.presentation.components.bottom_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.R
import com.example.movieapp.presentation.components.base_screen.MoviesBlock
import com.example.movieapp.presentation.components.tab_row.TabRow
import com.example.movieapp.presentation.screen.home_screen.HomeScreenUiState
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BottomBarScreen(
//    navController: NavController,
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState.Success
) {
    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background
    val homeTab = BottomItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = painterResource(id = R.drawable.home)
    )
    val searchTab = BottomItem(
        title = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = painterResource(id = R.drawable.search)
    )
    val watchListTab = BottomItem(
        title = "Watch List",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = painterResource(id = R.drawable.path)
    )
    val bottomBarItems = listOf(homeTab, searchTab, watchListTab)
    var selectedItemIndexed by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorBackground
            ) {
                bottomBarItems.forEachIndexed { index, bottomBarItem ->
                    BottomNavigationItem(
                        selected = true,
                        onClick = {
                        },
                        icon = {
                            Icon(
                                painter = bottomBarItem.unselectedIcon, contentDescription = null
                            )
                        },
                        label = {
                            Text(text = bottomBarItem.title, fontSize = 12.sp)
                        },
                    )
                }
            }
        },
    ) { innerPadding ->
        Column {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier.padding(top = 8.dp, start = 10.dp)
                ) {
                    MoviesBlock(movieList = uiState.moviePopular)

                    TabRow(uiState = uiState)
                }
            }
        }
    }
    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
}