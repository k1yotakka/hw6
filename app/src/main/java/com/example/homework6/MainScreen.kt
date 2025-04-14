package com.example.homework6

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MyViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    var city by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Прогноз погоды") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("Введите город") }
            )

            Button(
                onClick = {
                    if (city.isNotBlank()) {
                        viewModel.handleIntent(UiIntent.LoadWeather(city))
                    }
                }
            ) {
                Text("Показать погоду")
            }

            when (state) {
                is UiState.Loading -> {
                    CircularProgressIndicator()
                }
                is UiState.Success -> {
                    val data = (state as UiState.Success).data
                    Column {
                        data.forEach {
                            Text(text = it, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
                is UiState.Error -> {
                    Text(
                        text = "Ошибка: ${(state as UiState.Error).message}",
                        color = MaterialTheme.colorScheme.error
                    )
                }
                UiState.Idle -> {
                    Text("Введите город и нажмите кнопку")
                }
            }
        }
    }
}
