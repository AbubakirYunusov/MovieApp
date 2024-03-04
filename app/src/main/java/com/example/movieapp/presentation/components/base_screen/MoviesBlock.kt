package com.example.movieapp.presentation.components.base_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movieapp.presentation.components.item.TabRowItem
import com.example.movieapp.presentation.models.movie.MovieUiModel
import com.example.movieapp.presentation.theme.dp20
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MoviesBlock(
    movieList: ImmutableList<MovieUiModel>,
    onNavigateBlockToInfo: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier.padding(top = dp20)
    ) {
        items(items = movieList, key = { it.movieId }) {
            TabRowItem(
                imageUrl = it.posterPath,
                onNavigateBlockToInfo = onNavigateBlockToInfo,
                movieId = it.movieId,
            )
        }
    }
}