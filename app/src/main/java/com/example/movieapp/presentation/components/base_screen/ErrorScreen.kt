package com.example.movieapp.presentation.components.base_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.R
import com.example.movieapp.presentation.theme.dp16
import com.example.movieapp.presentation.theme.dp40
import com.example.movieapp.presentation.theme.sp22

@Composable
fun ErrorScreen(
    tryAgainCallback: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = dp40),
                text = stringResource(id = R.string.internet),
                fontWeight = FontWeight.Medium,
                fontSize = sp22,
            )
            Button(
                onClick = {
                    tryAgainCallback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp16)
            ) {
                Text(text = stringResource(id = R.string.try_again))
            }
        }
    }
}