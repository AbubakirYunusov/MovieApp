package com.example.movieapp.presentation.screen.details_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.presentation.components.base_screen.ErrorScreen
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp12
import com.example.movieapp.presentation.theme.dp130
import com.example.movieapp.presentation.theme.dp15
import com.example.movieapp.presentation.theme.dp170
import com.example.movieapp.presentation.theme.dp25
import com.example.movieapp.presentation.theme.dp3
import com.example.movieapp.presentation.theme.dp30
import com.example.movieapp.presentation.theme.dp65
import com.example.movieapp.presentation.theme.dp95
import com.example.movieapp.presentation.theme.sp12
import com.example.movieapp.presentation.theme.sp16
import com.example.movieapp.presentation.theme.sp18

@Composable
fun DetailsScreen(
    uiState: DetailsScreenUiState,
    viewModel: DetailsScreenViewModel,
    onGetMovieInfo: () -> Unit,
    callBackPopBackDetail: () -> Unit,
) {
    when (uiState) {
        is DetailsScreenUiState.Loading -> {}
        is DetailsScreenUiState.Success -> {
            LoadedScreen(
                uiState = uiState,
                callBackPopBackDetail = callBackPopBackDetail
            )
        }

        is DetailsScreenUiState.Error -> ErrorScreen {}
    }
    LaunchedEffect(key1 = true) {
        onGetMovieInfo()
    }
}

@Composable
fun LoadedScreen(
    uiState: DetailsScreenUiState.Success,
    modifier: Modifier = Modifier,
    callBackPopBackDetail: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dp10),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = {
                    callBackPopBackDetail()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = null,
                )
            }
            Text(
                modifier = modifier.padding(top = dp10),
                text = stringResource(id = R.string.text_detail),
                fontSize = sp18,
                fontWeight = FontWeight.SemiBold,
            )
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.path),
                    contentDescription = null,
                )
            }
        }
        Box(
            modifier = Modifier
        ) {
            Card {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth(),
                    model = Constants.POSTER_PATH_URL + uiState.movieInfo.backdropPath,
                    placeholder = painterResource(id = R.drawable.unknown),
                    contentDescription = null,
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = dp170, start = dp30),
            ) {
                Card(
                    modifier = Modifier
                        .height(dp130)
                        .width(dp95),
                ) {
                    AsyncImage(
                        model = Constants.POSTER_PATH_URL + uiState.movieInfo.posterPath,
                        placeholder = painterResource(id = R.drawable.unknown),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = dp65, start = dp15),
                    text = uiState.movieInfo.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = sp16,
                )
            }
        }
        Column(
            modifier = Modifier,
        ) {
            Row(
                modifier = Modifier
                    .padding(top = dp30)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.padding(top = dp3),
                    painter = painterResource(id = R.drawable.calendarblank),
                    contentDescription = null
                )
                Text(
                    text = " ${uiState.movieInfo.releaseDate}  |  ",
                )
                Icon(
                    modifier = Modifier.padding(top = dp3),
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier,
                    text = "  ${uiState.movieInfo.runtime}Minutes  | ",
                )
                Icon(
                    modifier = Modifier.padding(top = dp3),
                    painter = painterResource(id = R.drawable.ticket),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(id = R.string.text_action),
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dp12),
            text = stringResource(id = R.string.text_about_movie),
            fontWeight = FontWeight.Bold,
            fontSize = sp16,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .padding(top = dp15, start = dp25, end = dp30),
            text = uiState.movieInfo.overview,
            fontWeight = FontWeight.Medium,
            fontSize = sp12,
            textAlign = TextAlign.Center,
        )
    }
}