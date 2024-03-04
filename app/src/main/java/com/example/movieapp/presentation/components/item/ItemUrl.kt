package com.example.movieapp.presentation.components.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.theme.dp14
import com.example.movieapp.presentation.theme.dp160
import com.example.movieapp.presentation.theme.dp170
import com.example.movieapp.presentation.theme.dp18
import com.example.movieapp.presentation.theme.dp240
import com.example.movieapp.presentation.theme.dp8

@Composable
fun MovieItem(
    imageUrl: String,
    movieId: Int,
    modifier: Modifier = Modifier,
    onNavigateToInfo: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(dp8)
            .height(dp170)
            .width(dp160)
            .clickable {
                onNavigateToInfo(movieId)
            }

    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(dp14)),
                model = Constants.POSTER_PATH_URL + imageUrl,
                placeholder = painterResource(id = R.drawable.unknown),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun TabRowItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    movieId: Int,
    onNavigateBlockToInfo: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(dp8)
            .height(dp240)
            .width(dp170)
            .clickable {
                onNavigateBlockToInfo(movieId)
            }
    ) {
        Column {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(dp18)),
                model = Constants.POSTER_PATH_URL + imageUrl,
                placeholder = painterResource(id = R.drawable.unknown),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Preview
@Composable
fun ItemPreview() {
    MovieItem(
        imageUrl = "",
        onNavigateToInfo = {},
        movieId = 0
    )
}

@Preview
@Composable
fun TabRowItemPreview() {
    TabRowItem(
        imageUrl = "",
        onNavigateBlockToInfo = {},
        movieId = 0
    )
}