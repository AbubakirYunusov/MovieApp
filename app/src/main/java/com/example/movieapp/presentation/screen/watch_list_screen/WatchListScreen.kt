package com.example.movieapp.presentation.screen.watch_list_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp100
import com.example.movieapp.presentation.theme.sp18

@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    callBackPopBackSearch: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = dp10),
        ) {
            IconButton(
                onClick = {
                    callBackPopBackSearch()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrowback),
                    contentDescription = null,
                )
            }
            Text(
                modifier = modifier.padding(top = dp10, start = dp100),
                text = stringResource(id = R.string.text_watch_list),
                fontSize = sp18,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Preview
@Composable
fun WatchListScreenPreview() {
    WatchListScreen(
        callBackPopBackSearch = {}
    )
}