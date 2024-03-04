package com.example.movieapp.presentation.screen.home_screen

import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.movieapp.R
import com.example.movieapp.presentation.components.base_screen.ErrorScreen
import com.example.movieapp.presentation.components.base_screen.LoadingScreen
import com.example.movieapp.presentation.components.base_screen.MoviesBlock
import com.example.movieapp.presentation.components.tab_row.TabRow
import com.example.movieapp.presentation.theme.dp10
import com.example.movieapp.presentation.theme.dp12
import com.example.movieapp.presentation.theme.dp16
import com.example.movieapp.presentation.theme.dp18
import com.example.movieapp.presentation.theme.dp22
import com.example.movieapp.presentation.theme.sp18
import com.example.movieapp.presentation.theme.sp22
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(
    uiState: StateFlow<HomeScreenUiState>,
    modifier: Modifier = Modifier,
    uiStates: HomeScreenUiState.Success,
    viewModel: HomeScreenViewModel,
    onNavigateToInfo: (Int) -> Unit,
    onNavigateBlockToInfo: (Int) -> Unit,
    callBack: () -> Unit,
) {
    val backstackDispatcher = LocalOnBackPressedDispatcherOwner.current
    backstackDispatcher?.onBackPressedDispatcher?.addCallback {
        callBack()
    }
    var searchHome by remember {
        mutableStateOf("")
    }
    BoxWithConstraints {
        val verticalScrollState = rememberScrollState()
        val screenHeight = maxHeight
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(state = verticalScrollState)
        ) {
            Text(
                modifier = Modifier.padding(top = dp10, start = dp18),
                text = stringResource(id = R.string.what_watch),
                fontSize = sp22,
                fontWeight = FontWeight.Bold,
            )
            OutlinedTextField(modifier = Modifier
                .padding(horizontal = dp16)
                .padding(top = dp12)
                .fillMaxWidth(),
                shape = RoundedCornerShape(dp22),
                value = searchHome,
                onValueChange = { searchHome = it },
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
            MoviesBlock(
                movieList = uiStates.moviePopular,
                onNavigateBlockToInfo = onNavigateBlockToInfo,
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .height(screenHeight)
            ) {
                TabRow(
                    uiState = uiStates,
                    onNavigateToInfo = onNavigateToInfo,
                )
            }
        }
    }
}

@Composable
fun HomeScreens(
    uiState: StateFlow<HomeScreenUiState>,
    onNavigateToInfo: (Int) -> Unit,
    onNavigateBlockToInfo: (Int) -> Unit,
    viewModel: HomeScreenViewModel,
    callBack: () -> Unit,
) {
    when (val mainUiStateFlow = uiState.collectAsState().value) {
        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Success -> {
            HomeScreen(
                uiState = uiState,
                uiStates = mainUiStateFlow,
                viewModel = viewModel,
                onNavigateToInfo = onNavigateToInfo,
                callBack = callBack,
                onNavigateBlockToInfo = onNavigateBlockToInfo
            )
        }

        is HomeScreenUiState.Error -> ErrorScreen {}
    }
}