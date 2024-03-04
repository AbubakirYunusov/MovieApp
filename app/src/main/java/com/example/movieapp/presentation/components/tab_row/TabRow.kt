package com.example.movieapp.presentation.components.tab_row

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.presentation.components.item.MovieItem
import com.example.movieapp.presentation.screen.home_screen.HomeScreenUiState
import com.example.movieapp.presentation.theme.dp3
import com.example.movieapp.presentation.theme.dp4
import com.example.movieapp.presentation.theme.dp45
import com.example.movieapp.presentation.theme.sp20
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRow(
    uiState: HomeScreenUiState.Success,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit,
) {
    val listOf = listOf(
        uiState.moviePopular,
        uiState.movieTopRated,
        uiState.movieUpcoming,
        uiState.movieNowPlaying,
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { listOf.size }
    val defaultIndicator = @Composable { tabPositions: List<TabPosition> ->
        Box(
            modifier = modifier
                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                .height(dp3)
                .background(
                    color = Color.Gray
                ),
        )
    }
    Column(
        modifier = Modifier, verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            indicator = defaultIndicator,
            containerColor = Color.Transparent
        ) {
            listOf.forEachIndexed { index, _ ->
                val header = getListOfPageByPosition(index)
                Tab(text = {
                    Text(
                        text = header,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = sp20,
                        fontWeight = FontWeight.Bold
                    )
                }, selected = pagerState.currentPage == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dp4),
        ) { movie ->
            val scope = listOf[movie]
            LazyVerticalGrid(
                modifier = Modifier.padding(bottom = dp45),
                columns = GridCells.Fixed(3),
            ) {
                items(items = scope, key = { it.movieId }) {
                    MovieItem(
                        imageUrl = it.posterPath,
                        movieId = it.movieId,
                        onNavigateToInfo = onNavigateToInfo
                    )
                }
            }
        }
    }
}

@Composable
fun getListOfPageByPosition(position: Int): String = when (position) {
    0 -> "Popular"
    1 -> "Top Rated"
    2 -> "Now Playing"
    else -> "Upcoming"
}