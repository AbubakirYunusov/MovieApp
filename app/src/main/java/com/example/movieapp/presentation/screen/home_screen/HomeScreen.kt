@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.movieapp.presentation.screen.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presentation.components.base_screen.ErrorScreen
import com.example.movieapp.presentation.components.base_screen.LoadingScreen
import com.example.movieapp.presentation.components.bottom_bar.BottomBarScreen
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.sp22

@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel,
    uiState: HomeScreenUiState,
    modifier: Modifier = Modifier,
) {
    var search by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(top = dp10, start = 18.dp),
            text = stringResource(id = R.string.what_watch),
            fontSize = sp22,
            fontWeight = FontWeight.Bold,
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(22.dp),
            value = search,
            onValueChange = { search = it },
            trailingIcon ={
                Icon(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                )
            },
            placeholder = {
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = stringResource(id = R.string.search),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        )
        when (uiState) {
            is HomeScreenUiState.Loading -> LoadingScreen()
            is HomeScreenUiState.Success -> {
                BottomBarScreen(uiState = uiState)
            }

            is HomeScreenUiState.Error -> ErrorScreen {}
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {

}