package com.example.movieapp.presentation.components.base_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.presentation.components.item.TabRowItem
import com.example.movieapp.presentation.models.MoviePresentationModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MoviesBlock(
    movieList: ImmutableList<MoviePresentationModel>
) {
    LazyRow(
        modifier = Modifier.padding(top = 20.dp)
    ) {
        items(items = movieList, key = { it.movieId }) {
            TabRowItem(imageUrl = it.posterPath)
        }
    }
}