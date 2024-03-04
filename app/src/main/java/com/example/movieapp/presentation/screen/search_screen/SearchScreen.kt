package com.example.movieapp.presentation.screen.search_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp12
import com.example.movieapp.presentation.theme.dp16
import com.example.movieapp.presentation.theme.dp18
import com.example.movieapp.presentation.theme.dp22
import com.example.movieapp.presentation.theme.sp18

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    callBackPopBackSearch: () -> Unit,
) {
    var searchSearch by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dp10),
            horizontalArrangement = Arrangement.SpaceBetween
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
                modifier = modifier.padding(top = dp10),
                text = stringResource(id = R.string.search),
                fontSize = sp18,
                fontWeight = FontWeight.SemiBold,
            )
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.info_circle),
                    contentDescription = null,
                )
            }
        }
        OutlinedTextField(modifier = Modifier
            .padding(horizontal = dp16)
            .padding(top = dp18)
            .fillMaxWidth(),
            shape = RoundedCornerShape(dp22),
            value = searchSearch,
            onValueChange = { searchSearch = it },
            trailingIcon = {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                )
            },
            placeholder = {
                Text(
                    modifier = Modifier.padding(start = dp12),
                    text = stringResource(id = R.string.search),
                    fontWeight = FontWeight.Bold,
                    fontSize = sp18,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        )
    }
}


@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        callBackPopBackSearch = {}
    )
}